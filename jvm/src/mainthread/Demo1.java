package mainthread;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread1 thread1 = new MyThread1();
        thread1.start();
    }
}


