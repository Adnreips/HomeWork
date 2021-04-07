package project1.example.streams.collet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Program {

    public static void main(String[] args) {
//
//        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
//                new Phone("Nokia 9", 45000),
//                new Phone("Samsung Galaxy S9", 40000),
//                new Phone("LG G6", 32000));
//
//
//        Map<String, Phone> phones = phoneStream
//                .collect(Collectors.toMap(p->p.getName(), phone -> phone));
//
//        phones.forEach((k,v)->System.out.println(k + " " + v));

//
//        Определяем сколько раз элемент входит в список из записываем в map
        List<Object> list = Arrays.asList(1, 1, "a", "b", "c", "a");
        HashMap<Object, Integer> mapCount = list.stream().collect(HashMap::new,
                (map, value) -> {
                    map.merge(value, 1, Integer::sum);
                },
                HashMap::putAll);
        mapCount.forEach((k,v)-> System.out.println(k + " " + v));

    }
}

