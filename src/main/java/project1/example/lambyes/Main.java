package project1.example.lambyes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/**
 * Main
 *
 * @author "Andrei Prokofiev"
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException {

        


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


//        Person p1 = new Person("John", "Doe");
//        Person p2 = new Person("Alice", "Wonderland");
//
//        Comparator<Person> comparator = (o1, o2) -> o1.firstName.compareTo(o2.firstName);
//
//
//
//        System.out.println(comparator.compare(p1, p2));
//        System.out.println(comparator.reversed().compare(p1, p2));

//        PersonFactory<Person> personFactory = Person::new;
////        PersonFactory<Person> personFactory = new PersonFactory<Person>() {
////            @Override
////            public Person create(String firstName, String lastName) {
////                return new Person(firstName, lastName);
////            }
////        };
//        Person person = personFactory.create("Peter", "Parker");
//        System.out.println(person);
//        System.out.println(2>>>15);

    }

    private static void print(Collection c) {
        System.out.println("Collection");
    }
    private static void print(Set c) {
        System.out.println("Set");
    }
    private static void print(HashSet c) {
        System.out.println("HashSet");
    }



}
