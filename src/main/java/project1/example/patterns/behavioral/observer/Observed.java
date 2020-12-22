package project1.example.patterns.behavioral.observer;

/**
 * Observed
 *
 * @author "Andrei Prokofiev"
 */
public interface Observed {
    public void addObserver(Observer obsever);
    public void removeObserver(Observer observer);
    public void notifyObservers();


}
