package project1.example.patterns.behavioral.chain;

/**
 * EmailNotifier
 *
 * @author "Andrei Prokofiev"
 */
public class EmailNotifier extends  Notifer {

    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending email: " + message);
    }
}
