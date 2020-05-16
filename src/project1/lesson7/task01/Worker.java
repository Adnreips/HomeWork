package project1.lesson7.task01;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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
            array[i] = random.nextInt(1000)+5;
        }
        Arrays.sort(array);
        return array;
    }

    public static BigInteger factorial(Integer n) {
        BigInteger res = BigInteger.valueOf(1);
        int k = 2;
        if (n == 1 || n == 0) {
            hashMap.putIfAbsent(n, res);
            return res;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        if (hashMap != null) {

            CopyOnWriteArrayList<Integer> copyOn = new CopyOnWriteArrayList<>(hashMap.keySet());
            Collections.sort(copyOn);
            for (int i = copyOn.size() - 1; i >= 0; i--) {
                if (copyOn.get(i) < n) {
                    res = hashMap.get(copyOn.get(i));
                    k = copyOn.get(i);
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
