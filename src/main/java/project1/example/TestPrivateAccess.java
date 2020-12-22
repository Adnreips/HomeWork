package project1.example;

import java.lang.reflect.Field;

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
