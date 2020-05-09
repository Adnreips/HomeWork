package project1.lesson6.task01;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Main
 *
 * @author "Andrei Prokofiev"
 */
    public class Task01Main {
        public static void main(String[] args) throws IOException {
            try {
//                Path testFile1 = Files.createFile(Paths.get("test_new.txt"));
//                Path testFile2 = Files.createFile(Paths.get("test_new_result.txt"));

//                System.out.println("Был ли файлы успешно созданы?");
//                System.out.println(Files.exists(Paths.get("test_new.txt")));
//                System.out.println(Files.exists(Paths.get("test_new_result.txt")));

                String[] strings = Files.readString(Paths.get("test_new.txt"), StandardCharsets.UTF_8).split(" ");
                Arrays.sort(strings, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int result = o1.compareToIgnoreCase(o2);
                        return result;
                    }
                });
                Files.write(Paths.get("test_new_result.txt"),
                        Arrays.asList(strings), StandardCharsets.UTF_8);
                System.out.println(Arrays.asList(strings));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
