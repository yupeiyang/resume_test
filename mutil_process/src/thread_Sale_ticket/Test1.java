package thread_Sale_ticket;

/**
 * @author：ypy
 * @date:2020/4/20
 */
public class Test1 {
    public static void main(String[] args) {
        MainThread m1 = new MainThread();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        Thread t3 = new Thread(m1);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("----------------------------------------------");
        Thread_method_synchronized th1 = new Thread_method_synchronized();
        Thread tm1 = new Thread(th1);
        Thread tm2 = new Thread(th1);
        Thread tm3 = new Thread(th1);
        tm1.start();
        tm2.start();
        tm3.start();
        System.out.println("----------------------------------------------");
    }
}
