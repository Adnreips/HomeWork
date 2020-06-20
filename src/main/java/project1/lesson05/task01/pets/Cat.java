package project1.lesson05.task01.pets;

import project1.lesson05.task01.person.Person;

import java.util.UUID;

/**
 * Cat
 *
 * @author "Andrei Prokofiev"
 */
public class Cat extends Pet {

    public Cat(UUID id, String nickname, Person person, int weight) {
        super(id, nickname, person, weight);
    }


}
