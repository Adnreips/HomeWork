package project1.example.patterns.creational.abstractFabrica;

/**
 * DogsFactory
 *
 * @author "Andrei Prokofiev"
 */
public class DogsFactory implements AnimalFactory {
    @Override
    public Animal creat(String name) {

        if(name.equalsIgnoreCase("dog")) {
            return new Dog();
        }
        return null;
    }
}
