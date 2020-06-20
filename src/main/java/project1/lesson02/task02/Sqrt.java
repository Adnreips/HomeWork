package project1.lesson02.task02;

import java.util.Random;

/**
 * Sqrt
 * Класс провеверяет и вывод на экран число, если квадрат из целой части корня этого числа равен
 * этому числу.
 *
 * @author Andrei_Prokofiev
 */
public class Sqrt {

    /**
     * Метод возвращает корень числа,
     * если число отрицательное бросает исключение "IllegalArgumentException".
     *
     * @param k - случайное значение типа int.
     */
    public double sqrt(int k) {
        if (k < 0) throw new IllegalArgumentException("Value cannot be less than zero. Your value is " + k + ".");
        return Math.sqrt(k);
    }


    public static void main(String[] args) {
        Sqrt sqr = new Sqrt();
        Random random = new Random();

        int n = 100;
        for (int i = 0; i < n; i++) {
            int number = random.nextInt(10-5);

            double sqroot = sqr.sqrt(number);
            int intPart = (int)sqroot;

            double pow2 = Math.pow(intPart, 2);
            if (pow2 == number) {
                System.out.println("pow2=" + pow2);
            }
        }
    }
}