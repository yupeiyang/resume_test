package communicate_thread;

public class BaoZiPu extends Thread{
    private BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    public void run(){
        //定义包子种类判断变量
        int count = 0;
        while(true){
            //同步代码块，保证线程安全
            synchronized (baoZi){
                //对包子的状态进行判断
                if(baoZi.flag == true){
                    try{
                        //有包子的状态，阻塞包子铺线程生产包子
                        baoZi.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //判断包子种类
                if(count%2 == 0){
                    baoZi.pi = "薄皮";
                    baoZi.xian = "三鲜馅";
                }else{
                    baoZi.pi = "冰皮";
                    baoZi.xian = "牛肉大葱馅";
                }
                //轮流生产两种包子
                count++;
                //包子状态为没有状态，则包子铺生产包子
                System.out.println("包子铺的包子正在生产："+baoZi.pi+" : "+baoZi.xian);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                //包子铺生产完包子，修改包子的状态为有的状态
                baoZi.flag = true;
                //唤醒吃货线程，让吃货吃包子
                baoZi.notify();
                System.out.println("包子铺的包子已经生产好了："+baoZi.pi+" : "+baoZi.xian);
            }
        }
    }
}
