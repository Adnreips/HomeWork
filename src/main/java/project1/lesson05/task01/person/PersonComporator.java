package project1.lesson05.task01.person;

import java.util.Comparator;

/**
 * PersonComporator
 * Класс предлагает метод сравнение объектов типа Person и является наследником
 * интерефейса Comparator.
 *
 * @author Andrei
 */
public class PersonComporator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        int sexResult = o1.getSex().compareTo(o2.getSex());
        if (sexResult != 0) return sexResult;

        int ageResult = o1.getAge() - o2.getAge();
        if (ageResult != 0) return ageResult;

        int nameResult = o1.getName().compareTo(o2.getName());
        return nameResult;
    }


}

