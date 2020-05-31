package src.project1.lesson11.task02;

import java.util.Arrays;
import java.util.Random;

/**
 * Sqrt
 * Класс провеверяет и вывод на экран число, если квадрат из целой части корня этого числа равен
 * этому числу.
 *
 * @author Andrei_Prokofiev
 */
public class Sqrt {

    interface MyFuncInterface {
        double func(int k);
    }

    public static double sqrt(int k) {
        MyFuncInterface myFunc = n -> {
            if (k < 0) throw new IllegalArgumentException("Value cannot be less than zero. Your value is " + k + ".");
            return Math.sqrt(k);
        };
        return Math.sqrt(k);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10) - 5;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        Arrays.stream(array)
                .filter(x -> {
                    return x == sqrt(x) * sqrt(x);
                })
                .forEach(y -> System.out.print(y + " "));
    }
}