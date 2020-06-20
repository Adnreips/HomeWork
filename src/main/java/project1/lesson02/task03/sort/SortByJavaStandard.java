package project1.lesson02.task03.sort;

import part1.lesson02.task03.person.Person;

import java.util.Arrays;
import java.util.Comparator;

/**
 * SortByJavaStandart
 * Класс реализует сортировку методами представленными в стандартной библиотеке Java.
 *
 * @author Andrei_Prokofiev
 */
public class SortByJavaStandard implements Sort {

    /**
     * Метод получает на вход массив объектов типа Person и объект класса Comparator, сортирует массив
     * и возвращает отсортированный массив типа Person.
     *
     * @param arrayOfPersons - массив объектов типа Person.
     * @param comparator - объект который реализует сравнение объектов типа Person.
     */

    @Override
    public Person[] sort(Person[] arrayOfPersons, Comparator<Person> comparator) {
        Arrays.sort(arrayOfPersons, comparator);
        return arrayOfPersons;
    }
}
