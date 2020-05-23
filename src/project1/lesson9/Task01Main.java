package src.project1.lesson9;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Task01Main
 * Класс создает файл c именем "WorkerImpl.java", после его компилирует и
 * выполняет метод этого класс, который загружается с консоли в текстовом виде.
 *
 * @author "Andrei Prokofiev"
 */
public class Task01Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {

        Scanner in = new Scanner(System.in);

        String nameFile = "WorkerImpl.java";

        String className = nameFile.replace(".java", ".class");

        if (Files.exists(Paths.get(nameFile)) == false) {
            Path testFile1 = Files.createFile(Paths.get(nameFile));
        }

        String textFile = "public class WorkerImpl {\n" +
//                "    public void doWork() {\n" +
//                "        System.out.println(\"Hello!\");    \n" +
                in.nextLine() +
//              для занесения в консоль:  public void doWork() { System.out.println("Hello!");
                "    }\n" +
                "}";

        Files.writeString(Paths.get(nameFile), textFile);

        File[] files1 = new File[]{new File(nameFile)};

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits1 =
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1));

        compiler.getTask(null, fileManager, null, null, null, compilationUnits1).call();

        for (Diagnostic diagnostic : diagnostics.getDiagnostics())
            System.out.format("Error on line %d in %d%n",
                    diagnostic.getLineNumber(),
                    diagnostic.getSource());
        fileManager.close();
        try {
            MyClassLoader myClassLoader = new MyClassLoader();

            Class<?> objectClass = myClassLoader.getClassFromFile(new File(className));

            Constructor<?> constructor = objectClass.getConstructor();

            Object workerImpl = constructor.newInstance();

            Method[] methods = objectClass.getDeclaredMethods();

            Class[] parameterTypes = methods[0].getParameterTypes();

            Method method = objectClass.getDeclaredMethod("doWork", parameterTypes);

            method.invoke(workerImpl, null);

        } catch (InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}