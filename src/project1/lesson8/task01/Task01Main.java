package project1.lesson8.task01;

import project1.lesson8.task01.realization.MySerialize;
import project1.lesson8.task01.realization.Person;
import project1.lesson8.task01.realization.SimpleObject;

import java.io.*;

/**
 * Task01Main
 * Класс реализует основной функционал, который представлен в классе MySerialize.
 *
 * @author "Andrei Prokofiev"
 */
public class Task01Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        String file = "test1.txt";
        Person person = new Person(28, "Иван");
        MySerialize mySerialize = new MySerialize();

        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setA(999);
        simpleObject.setaBoolean(true);
        simpleObject.setD(1.1);
        simpleObject.setString("Aaaaa");
        simpleObject.setC('c');
        simpleObject.setPerson(person);
        System.out.println("До применения сериализации: ");
        System.out.println(simpleObject);
        mySerialize.serialize(simpleObject, file);
        System.out.println("После применения сериализации: ");
        System.out.println(mySerialize.deSerialize(file));

    }
}
