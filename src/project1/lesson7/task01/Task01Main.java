package project1.lesson7.task01;

import java.util.Arrays;
import java.util.Iterator;


/**
 * Task01Main
 *
 * @author "Andrei Prokofiev"
 */
public class Task01Main {

    public static void main(String[] args) throws Exception {

        Worker worker = new Worker();
        Integer[] array = worker.prepareArray();
        Long start1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            worker.factorial(array[i]);
        }
        for (Iterator it = worker.hashMap.entrySet().iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        Long stop1 = System.currentTimeMillis();
        Long time1 = stop1 - start1;
        Long start = System.currentTimeMillis();
        Arrays.stream(array).
                parallel().
                map(Worker::factorial).
                forEach(System.out::println);

        Long stop = System.currentTimeMillis();
        Long time = stop - start;
        System.out.printf("решение с использованием многопоточности, %d мс %n", time);
        System.out.printf("решение без использования многопоточности, %d мс", time1);

    }
}
