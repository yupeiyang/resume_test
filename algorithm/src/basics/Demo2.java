package basics;

class Person{
    protected String name;

    public Person(String name){
        this.name = name;
    }
}

class Student extends Person{
    private String name;

    Student(String name,String name1){
        super(name);
        this.name = name1;
    }

    //this是一个指向本对象的指针, 然而super是一个Java关键字
    public void getInfo(){
        System.out.println(super.name);
        System.out.println(this.name);
    }
}

public class Demo2 {
    public static void main(String[] args) {
        Student student = new Student("爸爸","儿子");
        student.getInfo();
    }
}
