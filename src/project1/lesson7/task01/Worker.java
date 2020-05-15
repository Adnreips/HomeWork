package project1.lesson7.task01;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Worker
 *
 * @author "Andrei Prokofiev"
 */
public class Worker {

    protected static ConcurrentHashMap<Integer, BigInteger> hashMap = new ConcurrentHashMap<>();


    public Integer[] prepareArray() {
        Random random = new Random();
        Integer[] array = new Integer[random.nextInt(1000) + 5];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        Arrays.sort(array);
        return array;
    }

    public static BigInteger factorial(Integer n) {
        BigInteger res = BigInteger.valueOf(1);
        int k = 2;
        if (n == 1) {
            hashMap.putIfAbsent(n, res);
            return res;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        if (hashMap != null) {

            Set<Integer> set = hashMap.keySet();
            Integer[] integers = new Integer[set.size()];
            Iterator iterator = set.iterator();
            for (int i = 0; i < integers.length; i++) {
                integers[i] = (Integer) iterator.next();
            }
            Arrays.sort(integers);
            for (int j = integers.length - 1; j >= 0; j--) {

                if (integers[j] < n) {
                    res = hashMap.get(integers[j]);
                    k = integers[j] + 1;
                    break;
                }
            }
        }
        for (; k <= n; k++) {
            res = res.multiply(BigInteger.valueOf(k));
        }
        hashMap.putIfAbsent(n, res);
        return res;
    }


}
