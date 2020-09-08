package lambdademo;

import lambda.IPerson1;

public class Test1 {

    private static void invokeshow1(String name, String address, IPerson1 iPerson){
        String info = name+" -> "+address;
        System.out.println("该学生的信息为："+info);
    }

    private static void invokeShow(String name,String address,IUser iUser){
        String info = name+" --- "+address;
        System.out.println("该用户的信息为："+info);
    }

    private static void invokefun(String name,IPerson iPerson){
        System.out.println("name : "+name);
    }

    private static void invokeAdd(int a,int b,IAccount iAccount){
        System.out.println("  ----  "+(a+b));
    }

    private static void invokeCook(ICook iCook){
        iCook.cookFood();
    }

    public static void main(String[] args) {

        int count = 10;
        while((count --) >0){
            new Thread(() -> System.out.println(Thread.currentThread().getName()+"当前线程名:")).start();
        }

        invokeShow("王安石","陕西西安",(String name,String address) -> {
            return name+" --- "+address;
        });

        invokefun("李白",(String name) -> {

        });

        invokeAdd(2,6,(int a,int b) -> {
            return a+b;
        });

        //抽象类IPerson的函数式接口的lambda接口
        invokeshow1("白居易","湖南岳阳",(String name,String address) -> {
            return name+" -> "+address;
        });

        invokeCook(() -> System.out.println("要准备吃饭了！"));
    }
}
