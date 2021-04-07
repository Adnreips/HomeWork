package project1.example.streams;

public class Main {

    public static void repeatText(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }

    public static void main(String[] args) {


//        repeatText("Hi",10);
    }
}
