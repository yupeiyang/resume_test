package thread_security_synchronized;

public class TestDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        Thread thread1 = new Thread(ticket2,"窗口1");
        Thread thread2 = new Thread(ticket2,"窗口2");
        Thread thread3 = new Thread(ticket2,"窗口3");

        //同时卖票
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
