package project1.lesson03.task01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Task31Main
 * В данном классе происходит выполнение основных методов,
 * которые представлены в классах ObjectBox и MathBox.
 * @author Andrei_Prokofiev
 */
public class Task31Main {
    public static void main(String[] args) {
        Number[] numbers = {12.0, 2.11, 3.11};
        Number[] numbers2 = {1, 2, 3, 4, 5, 1, 2.11, 3.11};

        MathBox mathBox = new MathBox(numbers);
        MathBox mathBox2 = new MathBox(numbers2);

        Set<Number> set = new HashSet<>();
        Set<Number> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        set3.add("adf");
        set3.add("as");



        set.addAll(Arrays.asList(numbers));
        System.out.println(set);

//        set = Arrays.stream(numbers).collect(Collectors.toSet());
//        System.out.println(set);
//
//        set2.addAll(Arrays.asList(numbers2));
//
//        System.out.println(set);
//        System.out.println(set2);

        System.out.println(mathBox.summator());

//        mathBox2.integerDelet();
//        System.out.println();
//
//        Object [] o = new Object[3];
//        try {MathBox mathBox3 = new MathBox((Number[]) o);}
//        catch (ClassCastException e){
//            System.out.println("Попытка положить Object в MathBox: ");
//            System.out.println(e);
//        }
//
//        System.out.println(mathBox.splitter( 2));
//        System.out.println(set);
//        System.out.println(mathBox.equals(mathBox2));
//
//        ObjectBox objectBox = new ObjectBox();
//        System.out.println(objectBox.getSet());
//
//        objectBox.addObject(set);
//        objectBox.addObject(set2);
//        objectBox.addObject(set3);
//        System.out.println(objectBox.getSet());
//        System.out.println("==============");
//
//        objectBox.dump();
//        System.out.println();
//        System.out.println("==============");
//
//        objectBox.deleteObject(set2);
//        System.out.println(objectBox.getSet());
    }
}
