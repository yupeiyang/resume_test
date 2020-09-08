package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"郁培阳");
        map.put(2,"李白");
        map.put(3,"杜天翼");

        //使用Map集合中的方法keySet(),把Map集合中所有的key取出來，存储到一个Set集合中去。
        Set<Integer> set = map.keySet();
        //使用iterator遍历map集合中的值（value）
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(map.get(it.next()));
        }
        System.out.println("---------------------");
        for(Integer integer:set){
            System.out.println(map.get(integer));
        }

        System.out.println("---------------------");
        Set<Map.Entry<Integer,String>> set1 = map.entrySet();
        Iterator<Map.Entry<Integer,String>> it1 = set1.iterator();
        //Entry<key,value> 是Map集合中的一个接口，用于存放Map集合中的键值对。
        while(it1.hasNext()){
            Map.Entry<Integer,String> entry = it1.next();
            System.out.println(entry);
        }
    }
}
