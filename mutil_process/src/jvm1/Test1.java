package jvm1;

public class Test1 {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());
        System.out.println("-----------------------------------");
        Test1 test1 = new Test1();
        System.out.println(test1.getClass().getClassLoader());
        System.out.println(test1.getClass().getClassLoader().getParent());
        System.out.println(test1.getClass().getClassLoader().getParent().getParent());
        //JVM默认分配的内存空间
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("maxMemory = "+maxMemory+"KB"+" = "+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("totalMemory = "+totalMemory+"KB"+" = "+(totalMemory/(double)1024/1024)+"MB");
        System.out.println("");
    }
}
