package thread_security;

public class TestDemo1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"窗口1");
        Thread thread2 = new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");

        //同时卖票
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
