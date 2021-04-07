package project1.example.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaDeveloperJobSite
 *
 * @author "Andrei Prokofiev"
 */
public class JavaDeveloperJobSite implements Observed{
   List<String> vacancies = new ArrayList<>();

   List<Observer> subscribers = new ArrayList<>();

   public void addVacancy(String vacancy){
       this.vacancies.add(vacancy);
       notifyObservers();
   }


    @Override
    public void addObserver(Observer obsever) {
        this.subscribers.add(obsever);
    }

    @Override
    public void removeObserver(Observer observer) {

       this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
       for (Observer observer : subscribers){
           observer.handleEvent(this.vacancies);
       }
    }
}
