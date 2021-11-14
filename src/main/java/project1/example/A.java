package project1.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A
 *
 * @author "Andrei Prokofiev"
 */
public class A {


    public static void main(String[] args) throws JsonProcessingException {
        // create an array of string objs
        String initList[] = { "One", "Two", "Four", "One",};

// create one list
        List list = new ArrayList(Arrays.asList(initList));

        System.out.println("List value before: "+list);

// create singleton list
        list = Collections.singletonList("OnlyOneElement");
        list.add("five"); //throws UnsupportedOperationException
        System.out.println("List value after: "+list);

    }
}
