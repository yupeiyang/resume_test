package Noname_inner_class_Thread;

//匿名内部类创建多线程
public class Noname_inner_class_Thread {
    public static void main(String[] args) {
        //线程的父类Thread
        new Thread(){
            //重写run()方法
            public void run(){
                for(int i = 0;i<50;i++){
                    System.out.println(Thread.currentThread()+" -> "+"AAA");
                }
            }
        }.start();
        //线程的接口Runnable
        Runnable runnable = new Runnable(){
            public void run(){
                for(int i = 0;i<50;i++){
                    System.out.println(Thread.currentThread()+" -> "+"BBB");
                }
            }
        };
        new Thread(runnable).start();
        new Thread(new Runnable(){
            public void run(){
                for(int i = 0;i<50;i++){
                    System.out.println(Thread.currentThread()+" -> "+"CCC");
                }
            }
        }).start();
    }
}

