package single_design_mode;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
* 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。
* 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
* 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。
* 这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
 注意：
* 1、单例类只能有一个实例。
* 2、单例类必须自己创建自己的唯一实例。
* 3、单例类必须给所有其他对象提供这一实例。
*/
public class SingleMode {
    public static SingleMode instance = new SingleMode();
    //构造函数设置为private是为了避免该类被实例化
    private SingleMode(){}
    public static SingleMode getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("SingleMode run ...");
    }
}
