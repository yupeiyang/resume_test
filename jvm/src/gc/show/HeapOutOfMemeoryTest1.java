package gc.show;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemeoryTest1 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        int count = 0;
        while(true){
            personList.add(new Person());
            System.out.println("Instance :"+(++count));
        }
    }
}
