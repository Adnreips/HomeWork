package project1.example.patterns.behavioral.strategy2;

public class Duck implements QuakBehavior, FlyBehavior {
    FlyBehavior flyBehavior;
    QuakBehavior quakBehavior;

    public Duck() {
    }

    void display(){
        System.out.println(this);
    };

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuakBehavior(QuakBehavior quakBehavior) {
        this.quakBehavior = quakBehavior;
    }

    public void perfomFly() {
        flyBehavior.fly();
    }

    public void perfomQuak() {
        quakBehavior.quack();
    }

    public void svim() {
        System.out.println("Swim");
    }

    @Override
    public String toString() {
//        return "Duck{" +
//                "flyBehavior=" + flyBehavior +
//                ", quakBehavior=" + quakBehavior +
//                '}';

        return String.format("Duck's behavior: %s, %s", flyBehavior, quakBehavior);

    }

    @Override
    public void fly() {
        this.fly();
    }

    @Override
    public void quack() {
        this.quack();
    }

}
