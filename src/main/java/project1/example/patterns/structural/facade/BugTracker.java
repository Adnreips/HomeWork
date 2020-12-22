package project1.example.patterns.structural.facade;

/**
 * BugTracker
 *
 * @author "Andrei Prokofiev"
 */
public class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint(){
        return activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint is active");
        activeSprint = true;
    }
    public void finishSprint(){
        System.out.println("Sprint finished");
        activeSprint = false;
    }
}
