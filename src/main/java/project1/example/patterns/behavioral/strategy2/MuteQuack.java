package project1.example.patterns.behavioral.strategy2;

public class MuteQuack implements QuakBehavior{
    @Override
    public void quack() {
        System.out.println("I can't quack");
    }

    @Override
    public String toString() {
        return "MuteQuack";
    }
}
