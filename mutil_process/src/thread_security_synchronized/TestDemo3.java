package thread_security_synchronized;

public class TestDemo3 {
    public static void main(String[] args) {
        Ticket3 ticket3 = new Ticket3();
        Thread thread1 = new Thread(ticket3,"窗口1");
        Thread thread2 = new Thread(ticket3,"窗口2");
        Thread thread3 = new Thread(ticket3,"窗口3");

        //同时卖票
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
