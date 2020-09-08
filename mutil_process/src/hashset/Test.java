package hashset;

import java.util.*;

public class Test {
    //可变参数的注意事项：1，一个方法的参数列表至多有一个可变参数；2、如果方法参数有多个，可变参数必须写在参数列表的末尾。
    public static int chang(String name,int...arr){
        System.out.println(name);
        System.out.println(arr);
        System.out.println(arr.length);
        return 0;
    }

    public static void main(String[] args) {
        //HashSet无序，不可重复
        HashSet set = new HashSet();
        set.add("adobe");
        set.add("yupeiyang");
        set.add("wangwenjuan");
        set.add("adobe");
        set.add("adobe");
        System.out.println(set);

        //LinkedHashSet：其底层是一个hash表（数组+链表/红黑树）+链表（此链表记录元素的存储顺序），来保证元素有序；有序，不可重复
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("yu");
        linkedHashSet.add("ha");
        linkedHashSet.add("wyu");
        linkedHashSet.add("gha");
        linkedHashSet.add("wyu");
        linkedHashSet.add("gha");
        System.out.println(linkedHashSet);

        System.out.println("可变参数举例:");
        System.out.println(chang("marry",1,2,3));

        Collections.addAll(set,linkedHashSet,"john","tom");
        System.out.println(set);

        System.out.println("-------------------------");
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.put("郁培阳",29));
        System.out.println(map.put("郁培阳",29));
        System.out.println(map.put("王阳明",29));
        System.out.println(map.remove("王阳明"));
    }
}
