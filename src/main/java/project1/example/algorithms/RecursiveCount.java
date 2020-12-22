package project1.example.algorithms;

import java.util.*;

/**
 * RecursiveCount
 *
 * @author "Andrei Prokofiev"
 */
public class RecursiveCount {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Сборщик мусора");
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
//        System.out.println(f(3));
        System.out.println(countElement(list, 3));

        String name = new String("dfdf");
        name.intern();





    }

    public static int f(int n) {
        if (n == 0) return 1;
        return n == 1 ? 1 : f(n - 1) * n;

    }

//    public static int countElement(List<Integer> list) {
//        if (list.isEmpty()) return 0;
//
//        list.remove(0);
//        return countElement(list) + 1;
//    }

    public static int countElement(List<Integer> list, int i) {

        if (list.size()  == i) return 0;
        int j =i;
        i++;
        return list.get(j) + countElement(list, i) ;
    }
}
