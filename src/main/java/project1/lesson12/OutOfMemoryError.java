package project1.lesson12;

import java.util.ArrayList;
import java.util.List;

/**
 * OutOfMemoryError
 * Класс демонстрирует утечку памяти с
 * получением ошибки Java Heap Space.
 *
 * @author "Andrei Prokofiev"
 */

public class OutOfMemoryError {
    public static List<String> list = new ArrayList<>();

    public static void stingList() {

        for (int i = 0; i < 100000000; i++) {


            list.add(new String("  ") + Math.random());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        stingList();
    }
}


