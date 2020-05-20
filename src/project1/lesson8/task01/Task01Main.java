package project1.lesson8.task01;

import project1.lesson8.task01.newClasses.MySerialize;
import project1.lesson8.task01.newClasses.Person;
import project1.lesson8.task01.newClasses.Sex;
import project1.lesson8.task01.newClasses.SimpleObject;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Task01Main
 *
 * @author "Andrei Prokofiev"
 */
public class Task01Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String file = "Test1.txt";

        Person person = new Person(28, "Иван");
        System.out.println(person);

        MySerialize mySerialize = new MySerialize();
//        mySerialize.serialize(person, file);

//        System.out.println(mySerialize.deSerialize(file));


        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setA(999);
        simpleObject.setaBoolean(true);
        simpleObject.setD(1.1);
        simpleObject.setString("Aaaaa");
        simpleObject.setC('c');
        simpleObject.setPerson(person);

        mySerialize.serialize(simpleObject, file);
        System.out.println(mySerialize.deSerialize(file));;


    }

}
