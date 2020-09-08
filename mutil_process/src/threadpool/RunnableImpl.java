package threadpool;

public class RunnableImpl implements Runnable {
    public void run(){
        System.out.println(Thread.currentThread().getName()+"创建一个新的线程");
    }
}
