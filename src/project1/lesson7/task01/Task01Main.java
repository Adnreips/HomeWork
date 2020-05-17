package project1.lesson7.task01;

import java.util.Arrays;
import java.util.Iterator;

import static project1.lesson7.task01.Worker.hashMap;


/**
 * Task01Main
 *
 * @author "Andrei Prokofiev"
 */
public class Task01Main {

    public static void main(String[] args) throws Exception {

        Worker worker = new Worker();
        Integer[] array = worker.prepareArray();
//        Integer[] array = {2, 3, 4, 5};
                System.out.println(Arrays.toString(array));
        Long start1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            System.out.println(worker.factorial(array[i]));
        }
        Long stop1 = System.currentTimeMillis();
        Long time1 = stop1 - start1;
        System.out.println("====================");
        Long start = System.currentTimeMillis();
        Arrays.stream(array).
                parallel().
                map(Worker::factorial).
                forEach(System.out::println);

        Long stop = System.currentTimeMillis();
        Long time = stop - start;
        System.out.println("длинна массива: " + array.length);
        System.out.printf("решение с использованием многопоточности, %d мс %n", time);
        System.out.printf("решение без использования многопоточности, %d мс", time1);
        hashMap.clear();
    }
}
