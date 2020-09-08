package thread_Sale_ticket;

public class Thread_method_synchronized implements Runnable {
    private int ticket = 10;
    public void run(){
        while(true){
            payTicket();
        }
    }
    //同步方法
    public synchronized void payTicket(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+" ： "+ticket);
            ticket--;
        }
    }
}
