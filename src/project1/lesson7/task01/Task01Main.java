package project1.lesson7.task01;

import java.math.BigInteger;
import java.util.Arrays;
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

//            Scanner in = new Scanner(System.in);
            Random random = new Random();


            Integer [] array = new Integer[random.nextInt(10)+5];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
            System.out.println(Arrays.toString(array));
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));

//            int n = in.nextInt();
//            System.out.println(factorial(n).toString());
//            ThreadPoolExecutor ggh =
//            Semaphore

        }

        public static BigInteger factorial(int n)
        {
            BigInteger res = BigInteger.valueOf(1);
            for (int i = 2; i <= n; i++){
                res = res.multiply(BigInteger.valueOf(i));
            }
            return res;
        }

}
