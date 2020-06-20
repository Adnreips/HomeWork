package project1.lesson05.task01.pets;

import part1.lesson05.task01.person.Person;

import java.util.Objects;
import java.util.UUID;

/**
 * Pet
 * Класс создает объект типа Pet (Домашний питомец).
 *
 * @author Andrei
 */
public class Pet {

    final UUID id;
    private String nickname;
    private Person person;
    private int weight;

    public Pet(UUID id, String nickname, Person person, int weight) {
        this.id = id;
        this.nickname = nickname;
        this.person = person;
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id= " + id +
                ", nickname= '" + nickname + '\'' +
                ", person= " + person +
                ", weight= " + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(getId(), pet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
