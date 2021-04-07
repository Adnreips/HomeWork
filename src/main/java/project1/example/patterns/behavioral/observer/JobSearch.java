package project1.example.patterns.behavioral.observer;

import org.apache.maven.surefire.shared.io.input.ObservableInputStream;

/**
 * JobSearch
 *
 * @author "Andrei Prokofiev"
 */
public class JobSearch {

    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();
        jobSite.addVacancy("First Java Position");
        jobSite.addVacancy("Second Java Position");

        Observer firstSuscriber = new Subscriber("Eugene");
        Observer secondSubscriber = new Subscriber("Roman");

        jobSite.addObserver(firstSuscriber);
        jobSite.addObserver(secondSubscriber);
        jobSite.addVacancy("Third Java Position");



    }
}
