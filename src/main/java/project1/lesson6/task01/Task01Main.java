package project1.lesson6.task01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Main
 * Программа создает, читает, затем заносит в новый файл отсортированный
 * по алфавиту список слов, найденных в исходном файле.
 *
 * @author "Andrei Prokofiev"
 */
    public class Task01Main {
        public static void main(String[] args) throws IOException {
            try {
                String path = "test_new.txt";
                String pathResult = "test_new_result.txt";

                if (Files.exists(Paths.get(path)) == false && Files.exists(Paths.get(pathResult)) == false ){
                List<String> list = new ArrayList<>();
                list.add("Иван");
                list.add("Андрей");
                list.add("Сергей");
                list.add("Ян");
                list.add("Егор");
                Path testFile1 = Files.createFile(Paths.get(path));
                Path testFile2 = Files.createFile(Paths.get(pathResult));
                    Files.write(Paths.get(path), list
                            , StandardCharsets.UTF_8);
                }

                List<String>  list = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

                Collections.sort(list, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int result = o1.compareToIgnoreCase(o2);
                        return result;
                    }
                });

                Files.write(Paths.get(pathResult),
                        list, StandardCharsets.UTF_8);
                System.out.println(Arrays.asList(list));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
