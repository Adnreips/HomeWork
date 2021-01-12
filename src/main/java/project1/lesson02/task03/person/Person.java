package project1.lesson02.task03.person;

import java.util.Objects;

/**
 * Person
 * Класс создает объект типа Person. Класс Person характеризуется полями:
 * @param age - возраст, целое число от 0 до 100.
 * @param sex - пол – объект класса Sex со строковыми константами внутри MAN, WOMAN.
 * @param name - имя, параметр типа String.
 * @author Andrey
 */
public class Person {
    int age;
    Sex sex;
    String name;

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age = " + age + ", sex = " + sex +
                ", name = '" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                getSex() == person.getSex() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getSex(), getName());
    }
}




