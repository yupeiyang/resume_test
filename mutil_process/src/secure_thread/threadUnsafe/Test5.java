package secure_thread.threadUnsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test5 {
    static int counter = 0;
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                counter++;
                lock.unlock();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                counter--;
                lock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }
}
