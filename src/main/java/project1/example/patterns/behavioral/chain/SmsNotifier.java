package project1.example.patterns.behavioral.chain;

/**
 * SmsNotifier
 *
 * @author "Andrei Prokofiev"
 */
public class SmsNotifier extends Notifer{

    public SmsNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {

        System.out.println("Send SMS to manager: " + message);

    }
}
