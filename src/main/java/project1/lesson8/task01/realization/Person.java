package project1.lesson8.task01.realization;

import java.io.Serializable;

/**
 * Person
 * Класс создает объект типа Person. Класс Person характеризуется полями:
 * @param age - возраст, целое число от 0 до 100.
 * @param name - имя, параметр типа String.
 * @author "Andrey_Prokofiev"
 */
public class Person implements Serializable {
    public int age;
    private String name;

    public Person(){}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}




