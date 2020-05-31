package src.project1.lesson11.task01;

import static java.util.stream.Stream.of;

/**
 * HelloWorldLambda
 * Класс моделирует ошибки «NullPointerException»,
 * «ArrayIndexOutOfBoundsException». А так же бросает
 * собственное исключение.
 *
 * @author "Andrei Prokofiev"
 */

interface MyArrays {
    void arrayGo(int[] array);
}

class MyArraysIndexOut {
    MyArrays arraysOut = n -> {
        for (int i = 0; i <= n.length; i++) {
            System.out.println(n[i]);
        }
    };
}

class HelloWorldLambda {
    static void arrayExecute(MyArrays my, int[] a) {
        my.arrayGo(a);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 4};
        MyArraysIndexOut myArrays = new MyArraysIndexOut();

        try {
            arrayExecute(myArrays.arraysOut, a);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        try {

            printLengthOfString(null);
        } catch (NullPointerException e) {

            System.out.print("Second exception: " + e + "\n");
        }

        throw new MyException("свой вариант ошибки через оператор throw");
    }

    public static void printLengthOfString(String s) {
//        System.out.println(s.length());

//        of(s).map(s1 -> s.length()).forEach(System.out::println);
        s.chars().map(s1 -> s.length()).forEach(System.out::println);
    }


}
