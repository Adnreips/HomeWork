package project1.example.patterns.creational;

/**
 * Singleton
 *
 * @author "Andrei Prokofiev"
 */
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){
    }

    public static Singleton getInstance() {
        if(singleton == null){
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
