package communicate_thread;

public class ChiHuo extends Thread {
    private BaoZi baoZi;

    public ChiHuo(BaoZi baoZi){
        this.baoZi = baoZi;
    }

    public void run(){
        while(true){
            //同步代码块，保证线程安全
            synchronized (baoZi){
                if(baoZi.flag == false){
                    try{
                        //没有包子，阻塞吃货线程，使得吃货等待包子铺线程生产包子
                        baoZi.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    //有包子的状态，吃货执行的吃包子操作
                    System.out.println("吃货正在吃包子："+baoZi.pi+" : "+baoZi.xian);
                    //吃货吃完包子，此时将包子设置为没有的状态
                    baoZi.flag = false;
                    //唤醒包子铺线程，使得包子铺生产包子
                    baoZi.notify();
                    System.out.println("吃货已经吃完了包子："+baoZi.pi+" : "+baoZi.xian);
                    System.out.println("------------------------------------");
                }
            }
        }
    }
}
