package project1.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A
 *
 * @author "Andrei Prokofiev"
 */
public class A {
//    int var1 = 123;
//    //declaring final variables
//    final int var2 = 345;
//    final int var3;
//
//    //Trying to initialize a blank final variable
////    var = 555; //Error
//    A() {
//        var1 = 111; //No Error
////        var2 = 333; //Compilation Error
////Initializing a blank final variable
//        var3 = 444; //No Error
//    }
//
//    //passing final parameters
//    void avg(int param1, final int param2) {
//        param1 = 2345; //No Error
////        param2 = 1223; //Compilation Error
//    }
//
//    //declaring final fields
//    void show() {
//        final int fieldVal = 300000;
////        fieldVal = 400000; //Error
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof A)) return false;
//        A a = (A) o;
//        return var1 == a.var1 && var2 == a.var2 && var3 == a.var3;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(var1, var2, var3);
//    }

    public static void main(String[] args) {
        int multiply = 3;

        final Integer[][] doubleArray = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        List<List<Integer>> collect = Arrays.stream(doubleArray).
                map(x -> Arrays.stream(x)
                        .map(o -> o * multiply)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(collect);


    }
//    {
//        System.out.println("Simple block");
//
//    }
//    static {
//        System.out.println("Static block");
//
//    }


//    public static void multiply(Integer[][] doubleArray, int x) {
//        for (int i = 0; i < doubleArray.length; i++) {
//            for (int j = 0; j < doubleArray[i].length; j++) {
//                doubleArray[i][j] = doubleArray[i][j] * x;
//            }
//        }
//
////        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
////        for (int i = 0; i < stackTrace.length; i++) {
////            System.out.println(stackTrace[i].getClassName());
////
////
////        }
////        Integer[] array = new Integer[]{1,2,3};
////
////        List<String> list =Arrays.asList("array","1","2");
////
////        Boolean b = list.stream().anyMatch("1"::equals);
////
////        System.out.println(b);
////
////    }
//
////    byte[] bytes = new byte[]{9,8};
////
////
////        System.out.println(Arrays.toString(bytes));
//
////        System.out.println(x.byteValue());
//
//
//    }
}
