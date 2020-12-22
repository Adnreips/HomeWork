package project1.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SequenceGeneratorBroken
 *
 * @author "Andrei Prokofiev"
 */
public class SequenceGeneratorBroken {
    private static final AtomicInteger counter = new AtomicInteger();

    public static int nextInt() {
        return counter.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(
                    () -> {
                        for (int j = 0; j < 1000; j++) nextInt();

                    });
            thread.start();
            threads.add(thread);
        }
//        for (Thread thread : threads){
//            thread.join();
//        }
        Semaphore semaphore =new Semaphore(10);


        System.out.println(counter);



    }
}
