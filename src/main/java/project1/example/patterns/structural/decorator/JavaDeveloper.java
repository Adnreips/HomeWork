package project1.example.patterns.structural.decorator;

/**
 * JavaDeveloper
 *
 * @author "Andrei Prokofiev"
 */
public class JavaDeveloper implements Developer {
    @Override
    public String makeJob() {
        return "Write Java code. ";
    }
}
