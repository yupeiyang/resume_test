package test1;

import thread.MyThread;

public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for(int i = 0;i<5;i++){
            try{
                myThread.sleep(3000);
                System.out.println(myThread.currentThread()+" : "+i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
