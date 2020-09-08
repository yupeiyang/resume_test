package secure_thread.threadUnsafe;

public class Test3 {
    static int counter = 0;

    static void increment(int counter)
    {
        counter++;
    }
    static void decrement(int counter)
    {
        counter--;
    }
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment(counter);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                decrement(counter);
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }
}
