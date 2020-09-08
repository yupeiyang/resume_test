package stringtable;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b"; //s3(ab)存于StringTable中
        /**
         * new StringBuilder().append("a").append("b").toString() : new String("ab")
         * 因为toString()操作有一个new的过程，因此，s4存放在堆内存中
         */
        String s4 = s1 + s2; //两个字符串变量的拼接，最后有一个new StringBuilder()的过程，s4存于堆内存中
        String s5 = "ab"; //ab已经存放在方法区的StringTable中
        String s6 = s4.intern(); //intern()方法尝试将字符串对象放入StringTable中，若存在不会放入，反之放入。并返回字符串对象的规范化表示形式

        //说明s3、s5指向的是同一个StringTable中的常量ab
        System.out.println(s3.hashCode() == s5.hashCode());
        System.out.println(s3.equals(s5)+"\n------------");

        System.out.println(s3 == s4); //false
        System.out.println(s3 == s5); //true
        System.out.println(s3 == s6); //true
        System.out.println(s4 == s5); //false
        System.out.println("------------");

        /**
         * ==运算符是判断两个对象是不是同一个对象，即他们的地址是否相等
         * object类中equals与==是等效的
         * 覆写equals更多的是追求两个对象在逻辑上的相等，你可以说是值相等，也可说是内容相等。(覆盖以后,覆盖equals时总要覆盖hashCode)
         * hashCode用于返回对象的hash值，主要用于查找的快捷性，因为hashCode也是在Object对象中就有的，所以所有Java对象都有hashCode，
         * 在HashTable和HashMap这一类的散列结构中，都是通过hashCode来查找在散列表中的位置的。
         */
        System.out.println(s4+" : "+s6);
        System.out.println(s4 == s6); //false
        System.out.println(s4.hashCode() == s6.hashCode());
        System.out.println(s4.equals(s6)+"\n------------");

        String x2 = new String("c") + new String("d"); //x2 = "ab" 存于堆中
        String x1 = "cd"; //存于方法区的StringTable中
        String x3 = x2.intern(); //存于方法区的StringTable中

        System.out.println(x1 == x2); //false
        System.out.println(x1 == x3); //true
        System.out.println(x2 == x3); //false
    }
}
