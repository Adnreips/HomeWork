package project1.example.patterns.structural.decorator;

/**
 * DeveloperDecorator
 *
 * @author "Andrei Prokofiev"
 */
public class DeveloperDecorator implements Developer{
   Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
