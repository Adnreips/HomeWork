package project1.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Test
 *
 * @author "Andrei Prokofiev"
 */
public class Test {



    public static void main(String[] args) {
        counter(3);

    }

    private static void counter(int n) {
        if(n==0) return;
        System.out.println(n);
        counter(n-1);
    }
}

