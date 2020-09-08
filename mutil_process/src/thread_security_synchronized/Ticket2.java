package thread_security_synchronized;

public class Ticket2 implements Runnable{
    private int ticket = 20;

    @Override
    public void run(){
        while(true){
            sellTicket();
        }
    }

    /**
     *  同步方法  
     *  其中，锁对象：谁调用这个方法 就是谁     
     *    隐含锁对象就是 ：this           
     */
    public synchronized void sellTicket(){
        if(ticket > 0){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //获取当前线程对象的名字
            String name = Thread.currentThread().getName();
            System.out.println(name+"正在卖："+ticket--);
        }
    }
}
