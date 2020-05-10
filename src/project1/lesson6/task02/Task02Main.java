package project1.lesson6.task02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static project1.lesson6.task02.GenerateTextFile.*;

/**
 * Task02Main
 * Реализует основной функционал, который представлен в классе GenerateTextFile, на выходе генерирует
 * n файлов размером size в каталоге path.
 * @param probability - вероятность попадания слова из случайного массива в генерируемый текст, %.
 *
 * @author "Andrei Prokofiev"
 */
public class Task02Main {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        int probability = 30;//вероятность вставки файла в %
        String path = "test.txt";
        int n4 = r.nextInt(999)+1;
        int n = 20;
        String[] words = getArray(n4);
        long size =  11024;
        getFiles(path, n, size, words, probability);
    }
}
