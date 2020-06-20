package project1.lesson02.task03.person;

import java.util.Comparator;

/**
 * PersonComporator
 * Класс предлагает метод сравнение объектов типа Person и является наследником
 * интерефейса Comparator.
 *
 * @author Andrei_Prokofiev
 */
public class PersonComporator implements Comparator<Person> {

    /**
     * Метод сравнивает передаваемые в него объекты по полям этих объектов
     * и возвращает положительное число, если первый объект больше второго, отрицательное
     * значение, если наоборот, и 0 если они равны.
     *
     * @param o1 - объект типа Person.
     * @param o2 - объект типа Person.
     */

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.age == o2.age && o1.name == o2.name && o1 != o2) {
            throw new PersconException("В списке присутствуют объекты с одинаковыми полями 'age' и 'name'");
        }

        int sexResult = o1.getSex().compareTo(o2.getSex());
        if (sexResult != 0) return sexResult;

        int ageResult = o1.getAge() - o2.getAge();
        if (ageResult != 0) return ageResult;

        int nameResult = o1.getName().compareTo(o2.getName());
        return nameResult;
    }
}

