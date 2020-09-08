package waiting_thread;

/**
 * 等待唤醒案例： 创建一个消费者线程和一个生产者线程
 *    创建一个消费者线程： 调用wait()方法，放弃cpu，进入waiting状态
 *    创建一个生产者线程： 生产资源，调用notify()方法，唤醒消费者线程
 *
 *    注意：
 *      消费者、生产者线程必须使用同步代码块包裹起来，保证等待和唤醒的线程同时至多有一个在执行。
 *      同步使用的锁对象必须保证唯一
 *      只有锁对象才能调用wait()、notify()方法。
 */
public class wait_and_notify {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(){
            public void run(){
                while(true){
                    synchronized (obj){
                        System.out.println("消费者通知生产者开始生产了！");
                        try{
                            obj.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        //唤醒生产者后的代码
                        System.out.println("唤醒生产者后消费者开始消耗生产产品。\n-------------------------");
                    }
                }
            }
        }.start();
        //创建一个生产者
        new Thread(){
            public void run(){
                while(true){
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    //保证等待和唤醒的线程只能有一个执行
                    synchronized (obj){
                        System.out.println("2秒钟后，生产者开始生产");
                        //唤醒生产者线程
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
