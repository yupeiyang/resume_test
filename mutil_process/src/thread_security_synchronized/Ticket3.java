package thread_security_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket3 implements Runnable {
    private int ticket = 20;

    //定义Lock锁对象
    Lock lock = new ReentrantLock();

    @Override
    public void run(){
        while(true){
            //添加同步锁
            lock.lock();
            if(ticket > 0){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                //获取当前线程对象的名字
                String name = Thread.currentThread().getName();
                System.out.println(name+"正在卖："+ticket--);
            }
            //释放同步锁
            lock.unlock();
        }
    }
}
