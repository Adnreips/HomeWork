package project1.example.patterns.behavioral.observer;

import java.util.List;

/**
 * Observer
 *
 * @author "Andrei Prokofiev"
 */
public interface Observer {
    public void handleEvent(List<String> vacancies);
}
