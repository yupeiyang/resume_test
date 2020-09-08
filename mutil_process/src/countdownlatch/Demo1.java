package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是一个基于线程计数器来实现并发访问控制，常用于主线程等待其他子线程都执行完毕后，再执行相应操作。
 */
public class Demo1 {
    private static void countdownLatchDemo(){
        //设置一个子线程数为2的CountDownLatch，每执行完一个子线程后，计数减一，直至为零后，CountDownLatch上的主线程将被唤醒并执行。
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        System.out.println(countDownLatch);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName()+"\t");
                //执行countDownLatch-1操作，直至减至为0
                countDownLatch.countDown();
                System.out.println(countDownLatch);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName()+"\t");
                countDownLatch.countDown();
                System.out.println(countDownLatch);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(Thread.currentThread().getName()+"\t");
                countDownLatch.countDown();
                System.out.println(countDownLatch);
            }
        }).start();

        try {
            //执行CountDownLatch的await()方法，等待子线程执行完再执行主线程。
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.print(Thread.currentThread().getName()+"开始执行\t");

        countdownLatchDemo();

        System.out.println(Thread.currentThread().getName()+"继续执行\t");
    }
}
