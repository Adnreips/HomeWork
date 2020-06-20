package project1.lesson03.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * ObjectBox
 * Класса хранит коллекцию Object и имеет следующий функционал:
 * - Метод addObject, добавляет объект в коллекцию.
 * - Метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 * - Метод dump, выводящий содержимое коллекции в строку.
 *
 * @author Andrei_Prokofiev
 */
public class ObjectBox<T> {

    protected Set<T> set = new HashSet<>();

    public Set<T> getSet() {
        return (Set<T>) set;
    }


    public void addObject (T t){
        set.add(t);
    }

    public void deleteObject (T t){
        set.remove(t);

    }

    public void dump () {
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectBox)) return false;
        ObjectBox objectBox = (ObjectBox) o;
        return set.equals(objectBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "set=" + set +
                '}';
    }
}
