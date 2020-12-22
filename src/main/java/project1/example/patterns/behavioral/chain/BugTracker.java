package project1.example.patterns.behavioral.chain;

import com.thoughtworks.qdox.model.expression.Not;

/**
 * BugTracker
 *
 * @author "Andrei Prokofiev"
 */
public class BugTracker {
    public static void main(String[] args) {
        Notifer reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifer emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifer smsNotifier = new SmsNotifier(Priority.ASAP);
        reportNotifier.setNextnofier(emailNotifier);
     emailNotifier.setNextnofier(smsNotifier);

//        reportNotifier.notifyManager("Everything is OK", Priority.ROUTINE);
//        reportNotifier.notifyManager("Something went wrong", Priority.IMPORTANT);
        reportNotifier.notifyManager("Houston, we've had a problem here!!!", Priority.ASAP);

    }
}
