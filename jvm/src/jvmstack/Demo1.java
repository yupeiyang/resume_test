package jvmstack;

public class Demo1 {
    public static void main(String[] args) {
        method1();
    }

    private static void method1(){
        method2(1,2);
    }

    private static int method2(int a,int b){
        int c = a+b;
        return c;
    }
}
