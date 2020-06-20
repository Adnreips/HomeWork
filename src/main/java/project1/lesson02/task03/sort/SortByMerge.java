package project1.lesson02.task03.sort;


import project1.lesson02.task03.person.Person;

import java.util.Comparator;

/**
 * SortByMerge
 * Класс предлагает метод сортировки объектов
 * методом слияния. Массив постепенно разбивается на две части (с использованием рекурсии), до тех пор пока в нем не останется
 * по одному элементу, затем начинается процесс слияния этих массивов (с использованием рекурсии),
 * они сравниваются и копируются в новый уже
 * отсортированный массив, по правилам:
 * - первые идут мужчины,
 * - выше в списке тот, кто более старший,
 * - имена сортируются по алфавиту.
 * Затем получившиеся массивы копируются в новый массив, сравнивая по очереди элемены по тем же правилам,
 * до тех пор пока не останется один остортированный массив объектов типа Person, который возвращается из метода.
 *
 * @author Andrei_Prokofiev
 */
public class SortByMerge implements Sort {

    /**
     * Метод сортирует передаваемый в него массив объектов типа Person
     * методом слияния и возвращает его.
     *
     * @param arrayOfPersons - массив объектов типа Person.
     * @param comparator - объект который реализует сравнение объектов типа Person.
     */

    @Override
        public Person[] sort(Person [] arrayOfPersons, Comparator<Person> comparator) {
        if (arrayOfPersons == null) {
            return null;
        }
        if (arrayOfPersons.length < 2) {
            return arrayOfPersons;
        }
        Person [] arrayB = new Person [arrayOfPersons.length / 2];
        System.arraycopy(arrayOfPersons, 0, arrayB, 0, arrayOfPersons.length / 2);

        Person [] arrayC = new Person [arrayOfPersons.length - arrayOfPersons.length / 2];
        System.arraycopy(arrayOfPersons, arrayOfPersons.length / 2, arrayC, 0,
                arrayOfPersons.length - arrayOfPersons.length / 2);

        arrayB = sort(arrayB, comparator);
        arrayC = sort(arrayC, comparator);

        return mergeArray(arrayB, arrayC, comparator);
    }

    /**
     * Метод соединяет передаваемые в него массивы объектов тип Person
     * и возвращает его в метод sort.
     *
     * @param arrayА - массив объектов типа Person.
     * @param arrayB - массив объектов типа Person.
     * @param comparator - объект который реализует сравнение объектов типа Person.
     */
    public Person [] mergeArray(Person [] arrayА, Person [] arrayB, Comparator<Person> comparator) {
        Person[] arrayC =new  Person[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;
        for (int i = 0; i < arrayC.length; i++) {

            if (positionA == arrayА.length) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayА[positionA];
                positionA++;
            } else if (comparator.compare(arrayА[positionA], arrayB[positionB]) < 0) {
                arrayC[i] = arrayА[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayC;
    }
}
