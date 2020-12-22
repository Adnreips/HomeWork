package project1.example.patterns.creational.abstractFabrica;

/**
 * Bird
 *
 * @author "Andrei Prokofiev"
 */
public class Bird implements Animal {

    @Override
    public void display() {
        System.out.println("Bird");
    }
}
