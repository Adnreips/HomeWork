package project1.lesson7.task01;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Task01Main
 *
 * @author "Andrei Prokofiev"
 */
public class Task01Main {

        public static void main (String[] args) throws Exception{

            Worker worker = new Worker();
            Integer [] array = worker.prepareArray();

//            Integer[] array = {621, 121, 421, 1031, 531};

//            System.out.println(Arrays.toString(array));


            Long start = System.currentTimeMillis();
//            System.out.println("решение без использования многопоточности");
//            for (int i = 0; i < array.length; i++) {
//                worker.factorial(array[i]);
//            }
//            for (Iterator it = worker.hashMap.entrySet().iterator(); it.hasNext(); ) {
//                System.out.println(it.next());
//            }



            System.out.println("решение с использованием многопоточности");
            Arrays.stream(array).
                    parallel().
                    map(Worker :: factorial).
                    forEach(System.out::println);

            Long stop = System.currentTimeMillis();

            System.out.println(stop - start);
//
//            for (Iterator it = worker.hashMap.entrySet().iterator(); it.hasNext(); ) {
//                System.out.println(it.next());
//            }



//            System.out.println(worker.hashMap);



        }




}
