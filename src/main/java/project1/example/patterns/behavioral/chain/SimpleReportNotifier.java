package project1.example.patterns.behavioral.chain;

/**
 * SimpleReportNotifier
 *
 * @author "Andrei Prokofiev"
 */
public class SimpleReportNotifier extends Notifer{

    public SimpleReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifying using simple report: " + message);
    }
}
