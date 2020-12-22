package project1.example.patterns.structural.facade;

/**
 * Developer
 *
 * @author "Andrei Prokofiev"
 */
public class Developer {

    public void doJobBeforeDeadline(BugTracker bugTracker) {
        if (bugTracker.isActiveSprint()) {
            System.out.println("Do work...");
        } else {
            System.out.println("Read Habrahabr...");
        }
    }
}
