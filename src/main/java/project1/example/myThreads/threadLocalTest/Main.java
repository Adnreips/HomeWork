package project1.example.myThreads.threadLocalTest;


public class Main {
    public static void main(String[] args) {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

    }



}
