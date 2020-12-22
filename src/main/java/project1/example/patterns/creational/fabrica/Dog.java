package project1.example.patterns.creational.fabrica;

/**
 * Dog
 *
 * @author "Andrei Prokofiev"
 */
public class Dog implements Animal {
    @Override
    public void voice() {
        System.out.println("Гав-гав");
    }
}
