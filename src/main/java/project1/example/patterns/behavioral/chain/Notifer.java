package project1.example.patterns.behavioral.chain;

/**
 * Notifer
 *
 * @author "Andrei Prokofiev"
 */
public abstract class Notifer {
    private int priority;
    private Notifer nextnofier;

    public Notifer(int priority) {
        this.priority = priority;
    }

    public void setNextnofier(Notifer nextnofier){
        this.nextnofier=nextnofier;
    }

    public void notifyManager(String message, int level){
        if(level >= priority){
            write(message);
        }
        if(nextnofier != null){
            nextnofier.notifyManager(message, level);
        }
    }

    public abstract void write(String message);
}

