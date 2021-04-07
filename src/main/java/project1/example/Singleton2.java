package project1.example;

import java.util.Stack;

/**
 * Singleton2
 *
 * @author "Andrei Prokofiev"
 */
public class Singleton2 {
    private static volatile Singleton2 singleton2;
    private static Stack<String> strings = new Stack<>();

    public static void main(String[] args) {
        strings.push("dfd");
        strings.push("dfd1");
        System.out.println(strings);
        strings.peek();
        System.out.println(strings.pop());
        System.out.println(strings);

    }
    private Singleton2() {
    }
    public static Singleton2 getSingleton2(){
        if (singleton2 == null){
            synchronized (Singleton2.class){
                if (singleton2 != null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
