package project1.example.patterns.creational.abstractFabrica;

/**
 * Main
 *
 * @author "Andrei Prokofiev"
 */
public class Main {

    public static void main(String[] args) {
        AnimalFactory animalFactory = new BirdsFactory();
        Animal animal = animalFactory.creat("Bird");
        animal.display();


    }

}
