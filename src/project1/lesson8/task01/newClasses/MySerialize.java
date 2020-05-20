package project1.lesson8.task01.newClasses;

import java.io.*;
import java.lang.reflect.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.lang.reflect.Field;

/**
 * MySerialize
 *
 * @author "Andrei Prokofiev"
 */
public class MySerialize {

    public void serialize(Object o, String file) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        System.out.println("serialize=================");
        Class myClassObject = o.getClass();
        if (Files.exists(Paths.get(file)) == false) {
            Files.createFile(Paths.get(file));
        }
        Files.writeString(Paths.get(file), myClassObject.getName());
        Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
        Field[] fields = myClassObject.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Files.writeString(Paths.get(file), fields[i].getName(), StandardOpenOption.APPEND);
            Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(Paths.get(file), fields[i].getType().getName(), StandardOpenOption.APPEND);
            Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
            fields[i].setAccessible(true);
            Files.writeString(Paths.get(file), fields[i].get(o).toString(), StandardOpenOption.APPEND);
            Files.writeString(Paths.get(file), System.lineSeparator(), StandardOpenOption.APPEND);
            // имя - "а" fields[i].getName()
            // тип - int
            // значение - 999 fields[i].get(o)

        }


    }

    public Object deSerialize(String file) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println("deSerialize=================");
        Object instance = null;

        try {
            File file1 = new File(file);
            FileReader fileReader = new FileReader(file1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String className = bufferedReader.readLine();
            Class myClassObject = Class.forName(className);
            System.out.println("Создаю объект: ");
            Constructor defaultConstructor = myClassObject.getConstructor();
            instance = defaultConstructor.newInstance();
            System.out.println(instance);
            String fromBufferedReader = bufferedReader.readLine();


            while (fromBufferedReader != null) {

                Field field = myClassObject.getDeclaredField(fromBufferedReader);
                fromBufferedReader = bufferedReader.readLine();
                field.setAccessible(true);

                if (fromBufferedReader.contains("byte")) {
                    fromBufferedReader = bufferedReader.readLine();
                    field.setByte(instance, Byte.parseByte(fromBufferedReader));
                } else {
                    if (fromBufferedReader.contains("short")) {
                        fromBufferedReader = bufferedReader.readLine();
                        field.setShort(instance, Short.parseShort(fromBufferedReader));
                    } else {
                        if (fromBufferedReader.contains("int")) {
                            fromBufferedReader = bufferedReader.readLine();
                            field.setInt(instance, Integer.parseInt(fromBufferedReader));
                        } else {
                            if (fromBufferedReader.contains("long")) {
                                fromBufferedReader = bufferedReader.readLine();
                                field.setLong(instance, Long.parseLong(fromBufferedReader));
                            } else {
                                if (fromBufferedReader.contains("boolean")) {
                                    fromBufferedReader = bufferedReader.readLine();
                                    field.setBoolean(instance, Boolean.valueOf(fromBufferedReader));
                                } else {
                                    if (fromBufferedReader.contains("char")) {
                                        fromBufferedReader = bufferedReader.readLine();
                                        field.setChar(instance, fromBufferedReader.charAt(0));
                                    } else {

                                        if (fromBufferedReader.contains("float")) {
                                            fromBufferedReader = bufferedReader.readLine();
                                            field.setFloat(instance, Float.parseFloat(fromBufferedReader));
                                        } else {
                                            if (fromBufferedReader.contains("double")) {
                                                fromBufferedReader = bufferedReader.readLine();
                                                field.setDouble(instance, Double.parseDouble(fromBufferedReader));
                                            } else {
                                                if (fromBufferedReader.contains("String")) {
                                                    fromBufferedReader = bufferedReader.readLine();
                                                    field.set(instance, fromBufferedReader);
                                                }
                                                else {
                                                    System.out.println(fromBufferedReader);
                                                    fromBufferedReader = bufferedReader.readLine();
                                                    System.out.println(fromBufferedReader);

//                                                    serialize(fromBufferedReader,"test2.txt");
                                                    field.set(instance, fromBufferedReader);

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                fromBufferedReader = bufferedReader.readLine();

            }
            // имя - "а" fields[i].getName()
            // значение - 999 fields[i].get(o)
            // тип - int

        } catch (Exception e) {
            e.printStackTrace();
        }


        return instance;
    }
}
//        int mods = myClassObject.getModifiers();
//        if (Modifier.isPublic(mods)) {
//            System.out.println("public");
//        }
//        if (Modifier.isAbstract(mods)) {
//            System.out.println("abstract");
//        }
//        if (Modifier.isFinal(mods)) {
//            System.out.println("final");
//        }
//        Field[] declaredFields = myClassObject.getDeclaredFields();
//        for (Field field :declaredFields) {
//            System.out.println(field);
//        }

//        declaredFields.setAccessible(true);
//        int horsepowerValue = horsepowerField.getInt(car);
//        System.out.println(horsepowerValue); //output: 500