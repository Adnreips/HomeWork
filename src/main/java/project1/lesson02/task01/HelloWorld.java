package project1.lesson02.task01;

/**
 * HelloWorld
 * Класс моделирует ошибки «NullPointerException»
 * и «ArrayIndexOutOfBoundsException».
 *
 * @author Andrei_Prokofiev
 */

public class HelloWorld {

    /**
     * Метод выводит в консоль передаваемый в него параметр.
     *
     * @param s - параметр типа String.
     */
    public void printLengthOfString(String s) {
        System.out.println(s.length());
    }

    /**
     * Метод выполняет обход значений массива.
     *
     * @param a массив значений типа int.
     */
    public void arrayIndexOutOfBoundsException(int[] a) {
        for (int i = 0; i <= a.length; i++) {
            int temp = a[i];
        }
    }


    public static void main(String[] args) {
        HelloWorld h = new HelloWorld();

        int[] b = {1, 2, 3};
        try {
            h.arrayIndexOutOfBoundsException(b);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("First exception: ");
            System.out.println(e);
        }

        try {
            h.printLengthOfString(null);
        } catch (NullPointerException e) {
            System.out.print("Second exception: ");
            System.out.println(e+"\n");
        }

        throw new MyException("свой вариант ошибки через оператор throw");
    }
}
