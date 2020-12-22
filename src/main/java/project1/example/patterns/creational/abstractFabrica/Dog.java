package project1.example.patterns.creational.abstractFabrica;

/**
 * Dog
 *
 * @author "Andrei Prokofiev"
 */
public class Dog implements Animal {
    @Override
    public void display() {
        System.out.println("Dog");
    }
}
