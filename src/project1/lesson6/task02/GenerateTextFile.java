package project1.lesson6.task02;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

/**
 * GenerateTextFile
 * Класс представляет собой генератор текстовых файлов.
 * И имеет следующие методы:
 * - getFiles который генерирует n файлов размером size в каталоге path,
 * - generateRandomLine генерирует предложение, которое состоит из 1 <= n1 <= 15 слов,
 * - generateRandomWord  слово состоит из 1 <= n2 <= 15,
 * - getParagraf генерирует абзац из 1 <= n3 <= 20 предложений,
 * - getArray генерирует массив из 1 <= n4 <= 1000 слов.
 *
 * @author "Andrei Prokofiev"
 */
public class GenerateTextFile {

    static void getFiles(String path, int n, long size, String[] words, int probability) throws IOException {
        try{
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(path).insert(4, i);
                System.out.println(sb);
                String newPath = String.valueOf(sb);
                if (Files.exists(Paths.get(newPath)) == false) {
                    Path testFile1 = Files.createFile(Paths.get(newPath));
                }
                getParagraf(probability, words.length, newPath, size);
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

    static String [] getArray(int arrayLenght){
        String[] arrayWords = new String[arrayLenght];
        for (int i = 0; i < arrayLenght; i++) {
            arrayWords[i] = String.valueOf(generateRandomWord(5));
        }
        return arrayWords;
    }

    static void getParagraf(int probability, int n4, String path, long size) throws IOException {
        Random r = new Random();
        int n1 = r.nextInt(14)+1;
        int n2 = r.nextInt(14)+1;
        int n3 = r.nextInt(19)+1;
        int numberOfParagraf = 3;
        try {
            File file = new File(path);
            for (int i = 0; i < numberOfParagraf; i++) {
                for (int j = 0; j < n3 || file.length() < size; j++) {
                    if (j == n3 - 1) {

                        StringBuilder list = generateRandomLine(n2, n1, probability, n4, path, size).append("\n\r");
                        Files.writeString(Paths.get(path), list, Charset.forName("windows-1251"), StandardOpenOption.APPEND);
                    } else {
                        StringBuilder list = generateRandomLine(n2, n1, probability, n4, path, size).append("\n");
                        Files.writeString(Paths.get(path), list, Charset.forName("windows-1251"), StandardOpenOption.APPEND);
                    }
                }
            }
            System.out.println(file.length() + " byte");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static StringBuilder generateRandomWord(int wordLength) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) { // For each letter in the word
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb;
    }

    static StringBuilder generateRandomLine(int wordLength, int countLine, int probability, int n4, String path, long size) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        File file = new File(path);
        for (int j = 0; j < countLine; j++) {
            for (int i = 0; i < wordLength && file.length() < size; i++) { // For each letter in the word
                char tmp = (char) ('a' + r.nextInt('z' - 'a'));
                if (j == 0 && i == 0) {
                    tmp = Character.toUpperCase(tmp);
                } else {
                    if (j == countLine - 1 && i == wordLength - 1) {
                        int c = r.nextInt(2) + 1;
                        switch (c) {
                            case 1:
                                tmp = ('.'); break;
                            case 2:
                                tmp = '!'; break;
                            case 3:
                                tmp = '?'; break;
                        }
                    }
                    else if (i == wordLength - 1) {
                        tmp = ' ';
                    }
                }
                sb.append(tmp);
            }
            if(probability >= r.nextInt(100) && j != 0 && j != countLine-1 && j != countLine-2){
                sb.append(getArray(n4)[r.nextInt(n4-1)]).append(' ');
                j++;
            }
        }
        return sb;
    }
}
