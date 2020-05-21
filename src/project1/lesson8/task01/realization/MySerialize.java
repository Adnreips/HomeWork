package project1.lesson8.task01.realization;

import java.io.*;
import java.lang.reflect.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.lang.reflect.Field;

/**
 * MySerialize
 * Класс содержит методы, которе выполняют сериализацию объекта Object в файл file
 * и десериализацию объекта из этого файла, данная операция выполняется,
 * как с примитивными типами так и с ссылочными.
 *
 * @author "Andrei Prokofiev"
 */
public class MySerialize {

    public void serialize(Object o, String file) throws IOException, IllegalAccessException {

        Class myClassObject = o.getClass();
        File file1 = new File(file);
        File file2 = new File("test2.txt");
        file1.delete();
        file2.delete();

        try (FileWriter fileWriter = new FileWriter(file1, true)) {

            fileWriter.write(myClassObject.getName());
            fileWriter.write(System.lineSeparator());
            Field[] fields = myClassObject.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                fileWriter.write(fields[i].getName());
                fileWriter.write(System.lineSeparator());
                if (fields[i].getType().isPrimitive() || fields[i].getType().getName().contains("String")) {
                    fileWriter.write(fields[i].getType().getName());
                    fileWriter.write(System.lineSeparator());
                } else {
                    fileWriter.write(fields[i].getType().getName());
                    fileWriter.write(System.lineSeparator());
                    serialize(fields[i].get(o), "test2.txt");
                }
                fields[i].setAccessible(true);
                fileWriter.write(fields[i].get(o).toString());
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
//        Files.writeString(Paths.get(file), myClassObject.getName());
//        Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
//        Field[] fields = myClassObject.getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//            Files.writeString(Paths.get(file), fields[i].getName(), StandardOpenOption.APPEND);
//            Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
//            if (fields[i].getType().isPrimitive() || fields[i].getType().getName().contains("String")) {
//                Files.writeString(Paths.get(file), fields[i].getType().getName(), StandardOpenOption.APPEND);
//                Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
//            } else {
//                Files.writeString(Paths.get(file), fields[i].getType().getName(), StandardOpenOption.APPEND);
//                Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
//                serialize(fields[i].get(o), "test2.txt");
//            }
//            fields[i].setAccessible(true);
//            Files.writeString(Paths.get(file), fields[i].get(o).toString(), StandardOpenOption.APPEND);
//            Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
//        }
    }

    public Object deSerialize(String file) {
        Object instance = null;
        File file1 = new File(file);
        File file2 = new File("test2.txt");

        try (FileReader fileReader = new FileReader(file1)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String className = bufferedReader.readLine();
            Class myClassObject = Class.forName(className);
            Constructor defaultConstructor = myClassObject.getConstructor();
            instance = defaultConstructor.newInstance();
            String fromBufferedReader = bufferedReader.readLine();

            while (fromBufferedReader != null) {
                Field field = myClassObject.getDeclaredField(fromBufferedReader);
                fromBufferedReader = bufferedReader.readLine();
                field.setAccessible(true);
                switch (fromBufferedReader) {
                    case ("byte"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setByte(instance, Byte.parseByte(fromBufferedReader));
                        break;
                    case ("short"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setShort(instance, Short.parseShort(fromBufferedReader));
                        break;
                    case ("int"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setInt(instance, Integer.parseInt(fromBufferedReader));
                        break;
                    case ("long"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setLong(instance, Long.parseLong(fromBufferedReader));
                        break;
                    case ("boolean"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setBoolean(instance, Boolean.valueOf(fromBufferedReader));
                        break;
                    case ("char"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setChar(instance, fromBufferedReader.charAt(0));
                        break;
                    case ("float"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setFloat(instance, Float.parseFloat(fromBufferedReader));
                        break;
                    case ("double"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.setDouble(instance, Double.parseDouble(fromBufferedReader));
                        break;
                    case ("java.lang.String"):
                        fromBufferedReader = bufferedReader.readLine();
                        field.set(instance, fromBufferedReader);
                        break;
                    default:
                        fromBufferedReader = bufferedReader.readLine();
                        field.set(instance, deSerialize("test2.txt"));
                        break;
                }
                fromBufferedReader = bufferedReader.readLine();
//                if (fromBufferedReader.contains("byte")) {
//                    fromBufferedReader = bufferedReader.readLine();
//                    field.setByte(instance, Byte.parseByte(fromBufferedReader));
//                } else {
//                    if (fromBufferedReader.contains("short")) {
//                        fromBufferedReader = bufferedReader.readLine();
//                        field.setShort(instance, Short.parseShort(fromBufferedReader));
//                    } else {
//                        if (fromBufferedReader.contains("int")) {
//                            fromBufferedReader = bufferedReader.readLine();
//                            field.setInt(instance, Integer.parseInt(fromBufferedReader));
//                        } else {
//                            if (fromBufferedReader.contains("long")) {
//                                fromBufferedReader = bufferedReader.readLine();
//                                field.setLong(instance, Long.parseLong(fromBufferedReader));
//                            } else {
//                                if (fromBufferedReader.contains("boolean")) {
//                                    fromBufferedReader = bufferedReader.readLine();
//                                    field.setBoolean(instance, Boolean.valueOf(fromBufferedReader));
//                                } else {
//                                    if (fromBufferedReader.contains("char")) {
//                                        fromBufferedReader = bufferedReader.readLine();
//                                        field.setChar(instance, fromBufferedReader.charAt(0));
//                                    } else {
//
//                                        if (fromBufferedReader.contains("float")) {
//                                            fromBufferedReader = bufferedReader.readLine();
//                                            field.setFloat(instance, Float.parseFloat(fromBufferedReader));
//                                        } else {
//                                            if (fromBufferedReader.contains("double")) {
//                                                fromBufferedReader = bufferedReader.readLine();
//                                                field.setDouble(instance, Double.parseDouble(fromBufferedReader));
//                                            } else {
//                                                if (fromBufferedReader.contains("String")) {
//                                                    fromBufferedReader = bufferedReader.readLine();
//                                                    field.set(instance, fromBufferedReader);
//                                                } else {
//                                                    fromBufferedReader = bufferedReader.readLine();
//                                                    System.out.println(fromBufferedReader);
//                                                    field.set(instance, deSerialize("test2.txt"));
//
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                fromBufferedReader = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
