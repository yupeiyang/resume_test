package hashmap;

import java.util.HashMap;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        show();
        show1();
    }

    //HashMap自定义存储类型键值，key不能重复
    private static void show(){
        //由于HashMap的key是String类型，String类已经重写了hashCode()和equals()方法，保证了key的唯一性。
        HashMap<String,Person> map = new HashMap<>();
        map.put("安徽",new Person(1,"阜阳"));
        map.put("江苏",new Person(2,"南京"));
        map.put("浙江",new Person(1,"杭州"));
        map.put("广东",new Person(1,"广州"));
        map.put("广东",new Person(1,"广州"));

        Set<String> set = map.keySet();
        for(String key:set){
            Person person = map.get(key);
            System.out.println(key+" : "+person);
        }
    }

    private static void show1(){
        //由于HashMap的key是Person类型，Person类中需要重写了hashCode()和equals()方法，保证了key的唯一性。
        HashMap<Person,String> map1 = new HashMap<>();
        map1.put(new Person(1,"阜阳"),"安徽");
        map1.put(new Person(2,"南京"),"江苏");
        map1.put(new Person(1,"杭州"),"浙江");
        map1.put(new Person(1,"广州"),"广东");
        map1.put(new Person(1,"广州"),"广东");

        Set<Person> set1 = map1.keySet();
        for(Person person1:set1){
            String str = map1.get(person1);
            System.out.println(person1+" : "+str);
        }
    }
}
