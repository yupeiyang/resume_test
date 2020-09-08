package gc.show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HeapOom {
    //通过JVisualVM观察GC的模拟过程
    byte[] bytes = new byte[1024*240];
    //HashMap<Integer,String> hashMap = new HashMap<Integer,String>();

    public static void main(String[] args) throws InterruptedException{
        List<HeapOom> all = new ArrayList<HeapOom>();
        while (true){
            all.add(new HeapOom());
            Thread.sleep(10);
        }
    }

}
