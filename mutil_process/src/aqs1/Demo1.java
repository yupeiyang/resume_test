package aqs1;

import static java.lang.Thread.sleep;

public class Demo1 {
    public static void main(String[] args) {
        MyLock lock = new MyLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"start locking");
                    try {
                        sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    System.out.println(Thread.currentThread().getName()+"Don’t locking");
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"start locking");
                }finally {
                    System.out.println(Thread.currentThread().getName()+"Don’t locking");
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"start locking");
                }finally {
                    System.out.println(Thread.currentThread().getName()+"Don’t locking");
                    lock.unlock();
                }
            }
        }).start();
    }
}
