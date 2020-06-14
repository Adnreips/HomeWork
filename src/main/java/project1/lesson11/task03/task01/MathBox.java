package project1.lesson11.task03.task01;

import project1.lesson11.task03.task02.ObjectBox;
import java.util.*;
import java.util.stream.Collectors;

/**
 * MathBox
 * Основной функционал класса представлен ниже:
 * - Конструктор на вход получает массив Number, элементы внутри объекта раскладываются в коллекцию HashSet.
 * - Метод summator, возвращает сумму всех элементов коллекции.
 * - Метод splitter, выполняет поочередное деление всех хранящихся в объекте элементов на делитель,
 * являющийся аргументом метода.
 * - Если метод integerDelet получает на вход Integer, то такой элемент удаляется.
 * @author Andrei_Prokofiev
 */
public class MathBox<T extends Number> extends ObjectBox<T> {

    public MathBox(T[] numbers) {
//        for (int i = 0; i < numbers.length; i++) {
//            set.add(numbers[i]);
//        }
       set = Arrays.stream(numbers).collect(Collectors.toSet());
    }

    @Override
    public Set<T> getSet() {
        return (Set<T>) set;
    }

    public Number summator(){

//        double sum = 0;
//        if (set == null) {
//            System.out.println("===========");
//
//            return null;
//        }
//        for (Number t : set){
//            sum = sum + t.doubleValue();
//        }
//        return sum;
        return set.stream().mapToDouble(s->s.doubleValue()).sum();
    }

    public Set<T> splitter(int del){
//        if (set == null) {
//            return null;
//        }
//        Set<Number> setTemp = new HashSet<>();
//        for (Number i : set){
//            setTemp.add(i.doubleValue()/del);
//        }
//        set.clear();
//        set.addAll((Collection<? extends T>) setTemp);
//
//        return (Set<T>) set;
       return (Set<T>) set.stream()
               .map(s-> (double) s/del).collect(Collectors.toSet());
    }

    public void integerDelet() {

//        for (Iterator<T> it = set.iterator(); it.hasNext(); ) {
//            Number n = it.next();
//            if (n instanceof Integer) {
//                it.remove();
//            }
//
//        }
        set.stream().filter(n -> (n

                instanceof Integer)==false).forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return set.equals(mathBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "set=" + set +
                '}';
    }
}
