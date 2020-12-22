package project1.example;

import java.util.concurrent.Callable;

/**
 * Cat
 *
 * @author "Andrei Prokofiev"
 */
public class Cat implements Callable<String> {
    private String name;

    public Cat(String name) {
        this.name = name;
    }



    @Override
    public String call() throws Exception {
        System.out.println("Worker");
        return name;
    }
}
