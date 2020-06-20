package project1.lesson02.task03;

import part1.lesson02.task03.person.*;
import part1.lesson02.task03.personGenerator.PersonGenerator;
import part1.lesson02.task03.sort.SortByJavaStandard;
import part1.lesson02.task03.sort.SortByMerge;
import part1.lesson02.task03.sort.SortByQuickSort;

import java.util.Arrays;
import java.util.List;

/**
 * Task3Main
 * Данный класс выполняет сортировку объектов типа Person стандартным методом Java, методом слияния,
 * и методом быстрой сортировки, и выводит на экран время выполнения этих методов.
 * @author Andrei_Prokofiev
 */
public class Task3Main {
    public static void main(String[] args) {
        long startTime, startTimeMerge, startTimeQuik;
        long stopTime, stopTimeMerge, stopTimeQuik;

        Person[] personList = PersonGenerator.generatePersons();
        Arrays.stream(personList).forEach(System.out::println);
        System.out.println();

        //======= My first sorting method
        startTime = System.nanoTime();
        try {
        List<Person> listStandrtSort = Arrays.asList(new SortByJavaStandard().sort(personList, new PersonComporator()));
        listStandrtSort.stream().forEach(System.out::println);}
        catch (PersconException e){
            System.out.println(e.getMessage());
        }
        stopTime = System.nanoTime();
        System.out.println();

        //======= My mergeSort
        startTimeMerge = System.nanoTime();
        try {
        List<Person> listMergeSort =  Arrays.asList(new SortByMerge().sort(personList, new PersonComporator()));
        listMergeSort.stream().forEach(System.out::println);}
        catch (PersconException e){
            System.out.println(e.getMessage());
        }
        stopTimeMerge = System.nanoTime();
        System.out.println();



        //======= My quickSort
        startTimeQuik = System.nanoTime();
        try {
        List<Person> listQuikSort =  Arrays.asList(new SortByQuickSort().sort(personList, new PersonComporator()));
        listQuikSort.stream().forEach(System.out::println);}
        catch (PersconException e){
            System.out.println(e.getMessage());
        }
        stopTimeQuik = System.nanoTime();
        System.out.println();


        System.out.print("\nВремя стандартной сортировки Java, нс: ");
        System.out.println(stopTime - startTime);

        System.out.print("\nВремя сортировки слиянием, нс: ");
        System.out.println(stopTimeMerge - startTimeMerge);

        System.out.print("\nВремя быстрой сортировки, нс: ");
        System.out.println(stopTimeQuik - startTimeQuik);
    }

}
