package project1.example.patterns.behavioral.strategy2;

public class Quack implements QuakBehavior {
    @Override
    public void quack() {
        System.out.println("Quak....");
    }

    @Override
    public String toString() {
        return "Quak";
    }
}
