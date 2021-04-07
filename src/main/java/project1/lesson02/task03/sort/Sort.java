package project1.lesson02.task03.sort;

import project1.lesson02.task03.person.Person;

import java.util.Comparator;

/**
 * Sort
 * Интерфейс в которым есть только один метод с двумя параметрами.
 *
 * @param arrayOfPersons - массив объектов типа Person.
 * @param comparator - объект который реализует сравнение объектов типа Person.
 *
 * @author Andrei_Prokofiev
 */
public interface Sort {
    Person[] sort(Person[] arrayOfPersons, Comparator<Person> comparator);

}
