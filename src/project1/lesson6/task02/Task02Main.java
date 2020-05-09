package project1.lesson6.task02;

import java.util.Arrays;
import java.util.Random;

/**
 * Task02Main
 *
 * @author "Andrei Prokofiev"
 */
public class Task02Main {
    public static void main(String[] args) {
        Random r = new Random();
        int n1 = r.nextInt(14)+1;
        int n2 = r.nextInt(14)+1;
        int n3 = r.nextInt(19)+1;
        int n4 = r.nextInt(999)+1;
        int numberOfParagraf = 2;
        int probability = 30;
        getParagraf(n1, n2, n3, numberOfParagraf, probability, n4);
//        System.out.println(generateRandomWord(n2));
        System.out.println(Arrays.asList(getArray(n4)));

    }

    static String [] getArray(int arrayLenght){
        String[] arrayWords = new String[arrayLenght];
        for (int i = 0; i < arrayLenght; i++) {
            arrayWords[i] = String.valueOf(generateRandomWord(5));
        }
        return arrayWords;
    }

    static void getParagraf(int n1, int n2, int n3, int numberOfParagraf, int probability, int n4){
        for (int i = 0; i < numberOfParagraf; i++) {
            for (int j = 0; j < n3; j++) {
                if (j == n3-1){
                    System.out.println(generateRandomLine(n2, n1, probability, n4).append("\r\n"));
                }else {
                    System.out.println(generateRandomLine(n2, n1, probability, n4));
                }
            }
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

    static StringBuilder generateRandomLine(int wordLength, int countLine, int probability, int n4) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for (int j = 0; j < countLine; j++) {
            for (int i = 0; i < wordLength; i++) { // For each letter in the word
                char tmp = (char) ('a' + r.nextInt('z' - 'a'));
                if (j == 0 && i == 0) {
                    tmp = Character.toUpperCase(tmp);
                } else {
                    if (j == countLine - 1 && i == wordLength - 1) {
                        int c = r.nextInt(2) + 1;
                        switch (c) {
                            case 1:
                                tmp = '.'; break;
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
            if(probability>r.nextInt(100) && j != 0 && j != countLine-1){
                sb.append(getArray(n4)[r.nextInt(n4-1)]);
            }
        }
        return sb;
    }
}
