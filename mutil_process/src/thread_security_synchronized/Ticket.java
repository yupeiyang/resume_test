package thread_security_synchronized;

public class Ticket implements Runnable{
    private int ticket = 20;

    //定义一个锁对象
    Object obj = new Object();

    @Override
    public void run(){
        while(true){
            //同步代码块
            synchronized (obj){
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
    }
}
