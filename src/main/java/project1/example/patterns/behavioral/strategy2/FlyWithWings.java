package project1.example.patterns.behavioral.strategy2;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm fly");
    }

    @Override
    public String toString() {
        return "FlyWithWings";
    }
}
