package project1.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * StreamApi
 *
 * @author "Andrei Prokofiev"
 */
public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Optional<Integer> sum = list.stream()
                .map(o->o+1)
                .reduce((o, o1)-> o+o1);
        System.out.println(sum.get());

        Arrays.asList("a1","a2", "a3", "a4", "a5").stream().peek(o->System.out.print(o));


    }
}
