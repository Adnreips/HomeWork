package project1.example;

import java.util.*;


public class ObjectService {



    public volatile HashMap<Object, Object> map;

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
//        map.put(1,"Sti");
//        map.put("", 1);
//        map.put("1", 1.01d);
//        System.out.println(map);
//
//        List<Integer> ints = new ArrayList<Integer>();
//        ints.add(3);
//
//        ints.add(2);
//        Collections.sort(ints);
//        System.out.println(ints);
//        ints.stream().sorted((o,o1)->o1.compareTo(o)).forEach(System.out::println);
//
//        Collections.synchronizedList(ints);

        System.out.println("KING".hashCode());

    }
    public static <T> T getFirst(List<? super T> list) {
        return (T) list.get(0); // compile-time error
    }



}
