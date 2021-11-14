package project1.example.myThreads.threadLocalTest;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        assertEquals(SharedMapWithUserContext.userContextPerUserId.size(), 2);
    }



}
