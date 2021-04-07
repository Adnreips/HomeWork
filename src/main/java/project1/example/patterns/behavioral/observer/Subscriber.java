package project1.example.patterns.behavioral.observer;

import java.util.List;

/**
 * ObserverImpl
 *
 * @author "Andrei Prokofiev"
 */
public class Subscriber implements Observer {
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {

        System.out.println("Dear, " + name +
                "\nWe have some changes in vacancies:\n" +vacancies +
                "\n==============================================\n");
    }
}
