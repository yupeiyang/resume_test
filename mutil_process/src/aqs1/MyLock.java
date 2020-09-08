package aqs1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//自定义不可重入锁
public class MyLock implements Lock {
    //独占锁
    static class MySync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                //若加上锁了，就设置锁对象的owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override //是否持有独占锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition(){
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    @Override //加锁，若不成功，则会进入等待获取锁对象的队列中
    public void lock() {
        sync.acquire(1);
    }

    @Override //加锁，可打断
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override //尝试加锁
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override //尝试加锁，不成功的话，进入等待队列，有时间限制
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override //释放锁
    public void unlock() {
        sync.release(1);
    }

    @Override //生成条件变量
    public Condition newCondition() {
        return sync.newCondition();
    }
}
