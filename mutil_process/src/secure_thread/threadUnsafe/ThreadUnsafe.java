package secure_thread.threadUnsafe;

import java.util.ArrayList;

public class ThreadUnsafe {
    ArrayList<String> list = new ArrayList<>();
    public void method1(int loopNumber){
        for(int i = 0;i<loopNumber;i++){
            //有一种出错情况是，如果线程2 还未 add，线程1 remove 就会报错
            method2();
            method3();
            for(String str:list){
                System.out.println(str);
            }
            if(list.size()<0){
                System.out.println("XXXXXXXXXXXXXXX");
            }
        }
    }

    private void method2(){
        list.add("a");
    }
    private void method3(){
        list.remove("a");
    }

    static final int i = 2;
    static final int j = 20;
    public static void main(String[] args) {
        ThreadUnsafe threadUnsafe = new ThreadUnsafe();
        for(int m = 0;m<i;m++){
            new Thread(() -> threadUnsafe.method1(j),"Thread"+1).start();
        }
    }
}
