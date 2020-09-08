package basics;

class Father{
    private String name;

    Father(){

    }

    Father(String name){
        this.name = name;
    }

    void getInfo(){
        System.out.println(name);
    }
}

class Son1 extends Father{
    private String name;

    Son1(String name){
        super();
        this.name = name;
    }

    void getInfo(){
        System.out.println(name);
    }
}

class Son2 extends Father{
    private String name;

    Son2(String name){
        super();
        this.name = name;
    }
}

/**
 * 当一个类继承于另一个类，子类中没有父类的方法时。用子类的对象调用方法时，
 * 会首先在子类中查找，如果子类中没有该方法，再到父类中查找。
 * 当一个方法只在父类中定义时，调用该方法时会使用父类中的属性。
 */

public class Demo4 {
    public static void main(String[] args) {
        Son1 son1 = new Son1("儿子1");
        son1.getInfo();

        Son2 son2 = new Son2("儿子2");
        son2.getInfo();
    }
}
