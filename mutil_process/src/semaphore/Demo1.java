package semaphore;

import java.util.concurrent.Semaphore;

/**
 * Semaphore翻译成字面意思为 信号量，Semaphore可以控同时访问的线程个数，
 * 通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 *
 * 尝试获取一个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
 * public boolean tryAcquire() { };
 * 尝试获取一个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false
 * public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException { };
 * 尝试获取permits个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
 * public boolean tryAcquire(int permits) { };
 * 尝试获取permits个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false
 * public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException { };
 */
public class Demo1 {
    public static void main(String[] args) {
        int N = 8; //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目

        for(int i = 0;i < N;i ++){
            new Worker(i,semaphore).start();
        }
    }
}


