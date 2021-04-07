package project1.example;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TestPrivateAccess {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        try {
            Class someClassClass = someClass.getClass();

            Field field =someClassClass.getDeclaredField("name");
            field.setAccessible(true);
            String fielValue = (String) field.get(someClass);
            System.out.println(fielValue);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
