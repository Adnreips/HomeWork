package project1.example.patterns.creational.fabrica;

/**
 * AnimalFactory
 *
 * @author "Andrei Prokofiev"
 */
public class AnimalFactory {
    public Animal creat(String animal) {
        if (animal.equals("Cat")) {
            return new Cat();
        } else if (animal.equals("Dog")) {
            return new Dog();
        }
        return null;

    }

}
