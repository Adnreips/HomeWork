package project1.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Test
 *
 * @author "Andrei Prokofiev"
 */
public class Test {
    String fdf;
    @Override
    protected void finalize() throws Throwable {
    }

    int test = 1;

     class A {
        int a = test;

    }
    static class B {
         Test test = new Test();
        int anInt =test.test;


    }
    public static void main(String[] args) {
        /*will fail - compilation error, you need an instance of Test to instantiate A*/
//        Test test = new Test();
//        Test.A testA = new Test().new A();
//        int tr = testA.a;
//
////        A a = new A();
//        /*will compile successfully, no instance of Test is needed to instantiate B */
//        B b = new B();
//         int b1 = b.anInt;
//        System.out.println(testA.toString());

//        Map<String, Integer> map = new HashMap<>();

//        int[] a = new int[3];
//        System.out.println(a.getClass().getName());

        String f = " 1 = df";
        String[] a = f.split("=");
        System.out.println(Integer.valueOf(a[0].trim()));


    }
}

