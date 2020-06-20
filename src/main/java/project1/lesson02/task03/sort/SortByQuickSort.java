package project1.lesson02.task03.sort;


import project1.lesson02.task03.person.Person;

import java.util.Comparator;

/**
 * SortByQuickSort
 * Класс выполняет сортировку моссива, методом быстрой сортировки. Суть метода состоит в том, что
 * выбирается опорный элемент из середины массива и сравнивается со значениями слева и справа. Элементы, которые меньше,
 * чем опорный перемещаются в левую часть массива, а которые больше в правую. Далее, используя рекурсию те же действия
 * проделываются с левой и правой частями массива, до тех пор пока массив не будет отсортирован.
 *
 * @author Andrei_Prokofiev
 */

public class SortByQuickSort implements Sort  {

    /**
     * Метод получает на вход массив объектов типа Person и объект класса Comparator, передает параметры в метод
     * quickSort и возвращает отсортированный массив типа Person.
     *
     * @param arrayOfPersons - массив объектов типа Person.
     * @param comparator - объект который реализует сравнение объектов типа Person.
     */
    @Override
    public Person[] sort (Person[] arrayOfPersons, Comparator<Person> comparator) {

        return quickSort(arrayOfPersons, 0, arrayOfPersons.length-1, comparator);
    }

    /**
     * Метод сортирует передаваемый в него массив объектов типа Person
     * методом быстрой сортировки и возвращает его.
     *
     * @param arrayOfPersons - массив объектов типа Person.
     * @param low - значение типа int, при первом обращении это нулевой индекс передаваемого массива,
     * далее левая граница сортируемого массива.
     * @param high - значение типа int, при первом обращении это последний индекс передаваемого массива,
     * далее правая граница сортируемого массива.
     * @param comparator - объект который реализует сравнение объектов типа Person.
     */
    public static Person[] quickSort(Person [] arrayOfPersons, int low, int high, Comparator<Person> comparator) {

        if (arrayOfPersons.length == 0)
            return arrayOfPersons;

        if (low >= high)
            return arrayOfPersons;

        int middle = low + (high - low) / 2;
        Person opora = arrayOfPersons[middle];

        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(arrayOfPersons[i],opora) < 0) {
                i++;
            }

            while (comparator.compare(arrayOfPersons[j],opora) > 0) {
                j--;
            }

            if (i <= j) {
                Person temp = arrayOfPersons[i];
                arrayOfPersons[i] = arrayOfPersons[j];
                arrayOfPersons[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arrayOfPersons, low, j,comparator);

        if (high > i)
            quickSort(arrayOfPersons, i, high, comparator);

        return arrayOfPersons;
    }
}
