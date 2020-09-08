package concurrenthashmap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordWrite {
    static final String ALPHA = "abcedfghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        int length = ALPHA.length();
        int count = 200;
        List<String> list = new ArrayList<>(length * count);
        for (int i = 0; i < length; i++) {
            char ch = ALPHA.charAt(i);
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(ch));
            }
        }
        Collections.shuffle(list);
        for (int i = 0; i < 26; i++) {
            System.out.println("111111111111");
            try (PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("D:\\IDEA_JAVA\\resume_test\\mutil_process\\src\\concurrenthashmap\\tmp\\" + (i+1) + ".txt")))) {
                String collect = list.subList(i * count, (i + 1) * count).stream()
                        .collect(Collectors.joining("\n"));
                out.print(collect);
                System.out.println("111111111111");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
