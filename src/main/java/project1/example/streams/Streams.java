package project1.example.streams;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.example.lambyes.Person;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Streams
 *
 * @author "Andrei Prokofiev"
 */
public class Streams {
    private static final Logger log = LogManager.getLogger(Streams.class);
    public static void main(String[] args) {

        List<Person> stringCollection = new ArrayList<>();
        Person person = new Person("a","b");
        Person person1 = new Person("c","d");
        Person person2 = new Person("e","a");

        stringCollection.add(person1);
        stringCollection.add(person2);
        stringCollection.add(person);
stringCollection.stream().forEach(e->System.out.print(e + " "));
        System.out.println();

        List<Person> stringCollectionSort = stringCollection.stream()
                .sorted((o1,o2)->o1.getLastName() != (o2.getLastName())?
                                o1.getLastName().compareTo(o2.getLastName()):
                        o1.getFirstName().compareTo(o2.getFirstName()))
                .collect(Collectors.toList());
        stringCollectionSort.stream().forEach(e->System.out.print(e + " "));




//        stringCollection.add("ddd2");
//        stringCollection.add("aaa2");
//        stringCollection.add("bbb1");
//        stringCollection.add("aaa1");
//        stringCollection.add("bbb3");
//        stringCollection.add("ccc");
//        stringCollection.add("bbb2");
//        stringCollection.add("ddd1");

//        stringCollection.forEach((o1)-> System.out.println(o1));
//
//        stringCollection
//                .stream()
//                .map(String::toUpperCase)
//                .sorted((a, b) -> a.compareTo(b))
//                .forEach(System.out::println);
//
////        System.out.println(stringCollection);
//
//        Optional<String> reduced =
//                stringCollection
//                        .stream()
//                        .sorted()
//                        .reduce((s1, s2) -> s1 + "#" + s2);
//
//        reduced.ifPresent(System.out::println);

//        Map<Integer, String> map = new HashMap<>();
//
//        System.out.println(map);
//
//        for (int i = 0; i < 10; i++) {
//            map.putIfAbsent(i, "val" + i);
//        }
//
//        System.out.println(map);
//        map.computeIfPresent(3, (num, val) -> val + num);
//        map.get(3);             // val33
//
//        System.out.println(map);
//
//        map.computeIfPresent(9, (num, val) -> null);
//        map.containsKey(9);     // false
//
//        System.out.println(map);
//
//        map.computeIfAbsent(23, num -> "val" + num);
//        map.containsKey(23);    // true
//
//        System.out.println(map);
//
//        map.computeIfAbsent(3, num -> "bam");
//        map.get(3);             // val33
//
//        System.out.println(map.getOrDefault(42, "not found"));
//        System.out.println(ZoneId.getAvailableZoneIds());// prints all available timezone ids
//        ZoneId zone1 = ZoneId.of("Europe/Berlin");
//        ZoneId zone2 = ZoneId.of("Europe/Moscow");
//        System.out.println(zone1.getRules());
//        System.out.println(zone2.getRules());
//        LocalTime now1 = LocalTime.now(zone1);
//        LocalTime now2 = LocalTime.now(zone2);
//        System.out.println(now1);
//        System.out.println(now2);

//
//        Iterator iterator = map.entrySet().iterator();
//        for (Map.Entry entry: map.entrySet()) {
//            System.out.println(entry.getValue());
//            System.out.println(entry.getKey());
//        }

//        map.forEach((o1, o2)-> System.out.println(o1));
//        List<String> list = Arrays.asList("abc", "“abc2", "“abc3”");
//        Optional<String> stream = list.stream().filter(element -> {
//            log.info("filter() was called");
//            return element.contains("2");
//        }).map(element -> {
//            log.info("map() was called");
//            return element.toUpperCase();
//        }).findFirst();

//        long size = list.stream().skip(2).map(element -> {
//            wasCalled();
//            return element.substring(0, 3);
//        }).count();
//        log.info(counter);
//
//        OptionalInt reduced =
//                IntStream.range(1, 4)
//                        .reduce((a, b) -> a + b);
//        reduced.stream().forEach(System.out::println);
//        int reducedParams = Stream.of(1, 2, 3)
//                .reduce(10, (a, b) -> a + b, (a, b) -> {
//                    log.info("combiner was called");
//                    return a + b;
//                });
//        log.info(reducedParams);
//        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
//                .reduce(10, (a, b) -> a + b, (a, b) -> {
//                    log.info("combiner was called");
//                    return a + b;
//                });
//        log.info(reducedParallel);
//        Метод collect ()
//        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
//                new Product(14, "orange"), new Product(13, "lemon"),
//                new Product(23, "bread"), new Product(13, "sugar"));

//    List<String> collectorCollection =
//            productList.stream().map(Product::getName).collect(Collectors.toList());
//    collectorCollection.forEach(System.out::println);

//        Сокращение до String : **
//        String listToString = productList.stream().map(Product::getName)
//                .collect(Collectors.joining(", ", "[", "]"));
//        System.out.println(listToString);

//        Обработка среднего значения всех числовых элементов потока: **

//        double averagePrice = productList.stream()
//                .collect(Collectors.averagingInt(Product::getPrice));
//        log.info(averagePrice);
//
//        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
//                .collect(Collectors.groupingBy(Product::getPrice));
//        System.out.println(collectorMapOfLists);

//        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1)
//                .limit(10);
//
//        streamFromIterate.forEach(System.out::println);

//        Path path = Paths.get("D:\\HomeWorkNew\\src\\main\\java\\project1\\example\\1.txt");
//        try {
//            Stream<String> streamOfStrings = Files.lines(path);
//            Stream<String> streamWithCharset =
//                    Files.lines(path, Charset.forName("UTF-8"));
//
//            streamOfStrings.forEach(System.out::println);
//            streamWithCharset.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }





}

    private static long counter;

    private static void wasCalled() {
        counter++;
    }
}
