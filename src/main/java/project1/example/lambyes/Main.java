package project1.example.lambyes;
import project1.example.generics.Converter;

import java.util.Comparator;
import java.util.function.Function;
/**
 * Main
 *
 * @author "Andrei Prokofiev"
 */
public class Main {
    public static void main(String[] args) {
//        final int[] num = {1};
//        System.out.println(num[0]);
//
//        Converter<Integer, String> stringConverter = (from) -> String.valueOf(num[0] = from);
//
//        System.out.println(stringConverter.convert(2));
//        System.out.println(num[0]);
//    }

//        Function<String, Integer> toInteger = Integer::valueOf;
//        Function<String, String> backToString = toInteger.andThen(String::valueOf);
//
//        String string = backToString.apply("123");     // "123"
//        System.out.println(string);


        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        Comparator<Person> comparator = (o1, o2) -> o1.firstName.compareTo(o2.firstName);



        System.out.println(comparator.compare(p1, p2));
        System.out.println(comparator.reversed().compare(p1, p2));

    }

}
