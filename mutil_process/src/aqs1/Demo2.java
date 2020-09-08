package aqs1;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Demo2 {
    static class MySync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                System.out.println(compareAndSetState(0,1));
                //若加上锁了，就设置锁对象的owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MySync sync = new MySync();
        sync.tryAcquire(1);
    }
}
