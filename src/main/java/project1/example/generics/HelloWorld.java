package project1.example.generics;

/**
 * HelloWorld
 *
 * @author "Andrei Prokofiev"
 */
public class HelloWorld{

    public static class NumberContainer<T extends Number> {
        private T number;

        public NumberContainer(T number)  { this.number = number; }

        public void print() {
            System.out.println(number);
        }
    }

    public static void main(String []args) {
        NumberContainer number1 = new NumberContainer(2L);
        NumberContainer number2 = new NumberContainer(1);


    }
}