package project1.lesson6.task02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static project1.lesson6.task02.GenerateTextFile.*;

/**
 * Task02Main
 *
 * @author "Andrei Prokofiev"
 */
public class Task02Main {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        int probability = 30;//вероятность вставки файла в %
        String path = "test.txt";
        int n4 = r.nextInt(999)+1;
        int n = 2;
        String[] words = getArray(n4);
        long size =  1024;
        getFiles(path, n, size, words, probability);
    }
}
