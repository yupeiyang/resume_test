package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用步骤：
 *      1.使用线程池的工厂类Executors里面提供的静态方法newFixedThreadPool生产一个指定数量的线程池。
 *      2.创建一个类，实现Runnable接口，重写run()方法，设置线程任务
 *      3.调用ExecutorService中的submit()方法，传递线程任务（实现类），开启线程，执行run（）方法。
 *      4.调用ExecutorService中的shutdown()方法销毁线程池(一般不建议执行，除非不使用多线程了)。
 *
 */
public class DemoThreadPool {
    public static void main(String[] args) {
        int count = 15;
        //创建一定数量的线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        while(count>0){
            //设置线程任务，并开启线程池
            executorService.submit(new RunnableImpl());
            count--;
        }
        //销毁线程池
        executorService.shutdown();
    }
}
