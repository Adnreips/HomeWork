package project1.example.patterns.creational.abstractFabrica;

/**
 * BirdsFactory
 *
 * @author "Andrei Prokofiev"
 */
public class BirdsFactory implements AnimalFactory {

    @Override
    public Animal creat(String name) {

        if (name.equalsIgnoreCase("bird")) {
            return new Bird();
        }
        return null;
    }

}
