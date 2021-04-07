package project1.example.patterns.behavioral.strategy2;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }

    @Override
    public String toString() {
        return "FlyNoWay";
    }
}
