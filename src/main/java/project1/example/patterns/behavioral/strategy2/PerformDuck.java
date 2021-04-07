package project1.example.patterns.behavioral.strategy2;

public class PerformDuck {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.setFlyBehavior(new FlyWithWings());
        mallardDuck.setQuakBehavior(new Quack());
        mallardDuck.perfomFly();
        mallardDuck.perfomQuak();
        mallardDuck.svim();
        mallardDuck.display();
        System.out.println("+++++++++++++++++++++++++++++++++++");
        Duck rubberDuck = new RubberDuck();
        rubberDuck.setFlyBehavior(new FlyNoWay());
        rubberDuck.setQuakBehavior(new MuteQuack());
        rubberDuck.perfomFly();
        rubberDuck.perfomQuak();
        rubberDuck.svim();
        rubberDuck.display();
    }
}

