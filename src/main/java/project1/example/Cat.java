package project1.example;

import java.util.concurrent.Callable;

/**
 * Cat
 *
 * @author "Andrei Prokofiev"
 */
public class Cat implements Callable<String> {
    private   String name;


    public String getName() {
        return name;
    }

    public Cat(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Cat cat = new Cat("f");
        Cat cat1 = new Cat(null);
        System.out.println(cat1);

    }

    @Override
    public String toString() {
//        return "Cat{" +
//                "name='" + name + '\'' +
//                '}';
        return String.format("Cat: ",name);
    }

    @Override
    public String call() throws Exception {
        System.out.println("Worker");
        return name;
    }
}
