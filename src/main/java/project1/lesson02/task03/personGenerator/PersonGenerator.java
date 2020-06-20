package project1.lesson02.task03.personGenerator;

import part1.lesson02.task03.person.ManName;
import part1.lesson02.task03.person.Person;
import part1.lesson02.task03.person.Sex;
import part1.lesson02.task03.person.WomanName;

import java.util.Random;

/**
 * PersonGenerator
 * Класс создает массив случайных объектов типа Person.
 *
 * @author Andrei_Prokofiev
 */
public class PersonGenerator {
    Person[] personList = new Person[10];
    Random random = new Random();
    ManName randomMan;
    WomanName randomWoman;

    /**
     * Метод создает массив случайных объектов типа Person и возвращает его.
     * @param personList - массив объектов типа Person.
     * @param random - объект класса Random, который инкапсулирует в себе последовательность псевдослучайных чисел.
     * @param randomMan - объект класса ManName, который предлагает выбор мужских имен.
     * @param randomWoman - объект класса WomanName, который предлагает выбор женских имен.
     */
    public static Person[] generatePersons() {
        Person[] personList = new Person[10000];
        Random random = new Random();
        ManName randomMan;
        WomanName randomWoman;
//        personList[0]=new Person(32, Sex.MAN, "Anton");
//        personList[1]=new Person(32, Sex.MAN, "Anton");

        for (int i = 0; i < personList.length; i++) {
            Sex randomSex = Sex.values()[random.nextInt(Sex.values().length)];

            if (randomSex.equals(Sex.MAN)) { randomMan = ManName.values()[random.nextInt(ManName.values().length)];
                personList[i] = new Person(random.nextInt(100), randomSex, randomMan.getName());}

            else { randomWoman = WomanName.values()[random.nextInt(WomanName.values().length)];
                personList[i] = new Person(random.nextInt(100), randomSex, randomWoman.getName());}
        }
        return personList;
    }
}
