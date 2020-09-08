package runable_1;

public class Test1 {
    public static void main(String[] args) {
        //实现多线程方式一：继承Thread类
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        for(int i = 0;i<2;i++){
            System.out.println(Thread.currentThread().getName());
        }

        //实现多线程方式二：实现Runnable接口
        RunnableThread runableThread= new RunnableThread();
        Thread thread1 = new Thread(runableThread);
        thread1.start();
        for(int i = 0;i<2;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
