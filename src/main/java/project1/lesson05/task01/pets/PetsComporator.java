package project1.lesson05.task01.pets;


import project1.lesson05.task01.person.PersonComporator;

import java.util.Comparator;


/**
 * PetsComporator
 * Класс предлагает метод сравнение объектов типа Pet и является наследником
 * интерефейса Comparator.
 *
 * @author Andrei
 */
public class PetsComporator<T> implements Comparator<Pet> {

    @Override
    public int compare(Pet o1, Pet o2) {
        PersonComporator personComporator = new PersonComporator();

        int personResult = personComporator.compare(o1.getPerson(), o2.getPerson());
        if (personResult !=0) return personResult;

        int nickResult = o1.getNickname().compareTo(o2.getNickname());
        if (nickResult !=0) return nickResult;

        int weightResult = o1.getWeight() - o2.getWeight();
        return weightResult;
    }
}

