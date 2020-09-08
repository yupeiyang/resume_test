package JVM_JMM;

class CodeZY{
    public CodeZY(){
        System.out.println("Code的构造方法11111");
    }
    {
        System.out.println("Code的构造块22222");
    }
    static {
        System.out.println("Code的静态代码块33333");
    }
}

public class CodeBlock03 {
    {
        System.out.println("CodeBlock03的构造块44444");
    }
    static {
        System.out.println("CodeBlock03的静态代码块55555");
    }
    public CodeBlock03(){
        System.out.println("CodeBlock03的构造方法66666");
    }

    public static void main(String[] args) {
        System.out.println("-----CodeBlock03的main方法77777-----");
        new CodeZY();
        System.out.println("----------------------------------");
        new CodeZY();
        System.out.println("----------------------------------");
        new CodeBlock03();
    }
}
