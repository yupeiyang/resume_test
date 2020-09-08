package semaphore;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    private int num;
    private Semaphore semaphore;

    public Worker(int num,Semaphore semaphore){
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try{
            //acquire()用来获取一个许可，若无许可能够获得，则会一直等待，直到获得许可。
            semaphore.acquire();
            System.out.println("工人"+this.num+"使用一个机器生产...");
            Thread.sleep(2000);
            System.out.println("工人"+this.num+"释放机器");
            //release()用来释放许可。注意，在释放许可之前，必须先获获得许可
            semaphore.release();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
