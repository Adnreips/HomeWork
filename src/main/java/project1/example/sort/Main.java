package project1.example.sort;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        int[] array = {6, 1, 3, 5, 2, 4, 7, 8};
        System.out.println(Arrays.toString(array));
        System.out.println();
        SortByMerge sortByMerge = new SortByMerge();

        int[] sortArray = sortByMerge.sortArray(array);
        System.out.println(Arrays.toString(sortArray));
        Set<Integer> set = new TreeSet<>();
        set.size();


    }
}
