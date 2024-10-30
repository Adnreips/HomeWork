package other;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";

        list.add(a);
        list.add(b);
        list.add(c);

        List<String> backedList = new ArrayList<>(list.subList(0, 2));
        list.add(0, d);
        System.out.println("2b: " + backedList);
        System.out.println("2b: " + list);
    }
}
