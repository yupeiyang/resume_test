package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class TestDemo2 {
    private static void invokecac(int a,int b,ICac iCac){
        int sum = iCac.cac(a,b);
        System.out.println(sum);
    }

    private static void invokeshow(String name,String address,IPerson1 iPerson){
        String info = name+" -> "+address;
        System.out.println("该学生的信息为："+info);
    }

    private static void testShow(IPerson iPerson){
        iPerson.show();
    }

    public static void main(String[] args) {
        //Runnable接口的函数式接口的lambda表达式练习
        new Thread(()-> System.out.println(Thread.currentThread().getName()+" lambda 表达式 ： ")).start();
        //IPerson接口的show()函数式接口的lambda表达式练习
        testShow(()-> System.out.println("Person : show..."));

        Person[] array = {
                new Person("李白",28),
                new Person("王安石",21),
                new Person("曾巩",48),
                new Person("白居易",31),
                new Person("杜牧",19)
        };
        /**
         * 1. 使用Lambda必须具有接口，且要求**接口中有且仅有一个抽象方法**。
         *    无论是JDK内置的`Runnable`、`Comparator`接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
         * 2. 使用Lambda必须具有**上下文推断**。
         *    也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。
         *
         * > 备注：有且仅有一个抽象方法的接口，称为“**函数式接口**”。
         */

        //匿名内部类，对集合中的person实例对象进行按年龄排序
        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Arrays.sort(array,comp);

        //lambda表达式写法
        Arrays.sort(array,(Person a,Person b)->{
            return a.getAge() - b.getAge();
        });

        for(Person person:array){
            System.out.println(person);
        }

        //抽象类ICal的函数式接口:lambda表达式
        invokecac(100,100,(int c,int d)-> {
            return c + d;
        });

        //抽象类IPerson的函数式接口的lambda接口
        invokeshow("白居易","湖南岳阳",(String name,String address) -> {
            return name+" -> "+address;
        });
    }
}
