package lambda;

public class TestDemo1 {
    //lambda表达式,练习
    public static void main(String[] args) {
        //Runnable接口的函数式接口的lambda表达式练习
        new Thread(()-> System.out.println(Thread.currentThread().getName()+" lambda 表达式 ： ")).start();
        //IPerson接口的show()函数式接口的lambda表达式练习
        testShow(()-> System.out.println("Person : show..."));
    }
    private static void testShow(IPerson iPerson){
        iPerson.show();
    }
}
