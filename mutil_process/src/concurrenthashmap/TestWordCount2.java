package concurrenthashmap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class TestWordCount2 {
    public static void main(String[] args) {
        demo(
                () -> new ConcurrentHashMap<String,Integer>(),
                (map,words) -> {
                    for(String word:words){
                        Integer counter = map.get(word);
                        int newValue = counter == null ? 1:counter+1;
                        map.put(word,newValue);
                        /**
                         * 因为ConcurrentHashMap是一个细粒度的线程安全的Map集合，
                         * 此时将map的get、put操作外加上synchronized使得锁的粒度加大，降低了多线程的并发度.
                         */
//                        synchronized (map){
//                            Integer counter = map.get(word);
//                            int newValue = counter == null ? 1:counter+1;
//                            map.put(word,newValue);
//                        }
                    }
                }
        );
    }

    private static <V> void demo(Supplier<Map<String, V>> supplier, BiConsumer<Map<String, V>, List<String>> consumer) {
        Map<String, V> counterMap = supplier.get();
        // key value
        // a   200
        // b   200
        List<Thread> ts = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            int idx = i;
            Thread thread = new Thread(() -> {
                List<String> words = readFromFile(idx);
                consumer.accept(counterMap, words);
            });
            ts.add(thread);
        }

        ts.forEach(t -> t.start());
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(counterMap);
    }

    public static List<String> readFromFile(int i) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IDEA_JAVA\\resume_test\\mutil_process\\src\\concurrenthashmap\\tmp\\" + i + ".txt")))) {
            while (true) {
                String word = in.readLine();
                if (word == null) {
                    break;
                }
                words.add(word);
            }
            return words;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
