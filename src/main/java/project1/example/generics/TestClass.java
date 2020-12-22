package project1.example.generics;

/**
 * TestClass
 *
 * @author "Andrei Prokofiev"
 */

public class TestClass<T> {

    private T value1;
    private T value2;



    public void printValues() {
        System.out.println(value1);
        System.out.println(value2);
    }

    public static <T> TestClass<T> createAndAdd2Values(T o1, T o2) {
        TestClass<T> result = new TestClass();
        result.value1 = (T) o1;
        result.value2 = (T) o2;
        return result;
    }

    public static void main(String[] args) {
        Integer d = 22;
        Integer s = 22;
        TestClass<Integer> test = createAndAdd2Values(d, s);
        test.printValues();
    }
}