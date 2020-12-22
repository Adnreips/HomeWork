package project1.example.algorithms;

import java.util.Arrays;

/**
 * BinarySych
 *
 * @author "Andrei Prokofiev"
 */
public class BinarySych {


    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 6, 1, 2, 5, 11, 15, 14, 35, 3, 3, 35, 35, 3, 3, 2, 1, 6, 37};
        Arrays.sort(array);
        BinarySych binarySych = new BinarySych();
        int count = 0;
        System.out.println(binarySych.binarySych(array, 100, count));
    }

    public boolean binarySych(int[] array, int item, int count) {
        double low = 0;
        double high = array.length - 1;
        int goal = 0;
        while (low <= high) {
            count++;
            goal = array[(int) ((low + high) / 2)];
            if (low == high && goal != item){
                return false;
            }

            if (goal == item) {
                System.out.println("Иттераций: " + count);
                return true;
            }
            if (goal < item) {
                low = ((low + high) / 2);
                low = Math.round(low);

            }
            if (goal > item) {
                high = ((low + high) / 2);
                high = Math.round(high);

            }
        }
        System.out.println("Иттераций: " + count);

        return false;

    }


}
