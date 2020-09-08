package thread_Sale_ticket;

public class MainThread implements Runnable {
    private int ticket = 20;
    //定义一个锁对象
    Object obj = new Object();
    @Override
    public void run(){
        while(true){
            //同步代码块
            synchronized (obj){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+" ： "+ticket);
                    ticket--;
                }
            }
        }
    }
}
