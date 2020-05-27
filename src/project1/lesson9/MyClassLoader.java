package src.project1.lesson9;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/**
 * MyClassLoader
 * Класс представляет собой кастомный загрузчик классов.
 *
 * @author "Andrei Prokofiev"
 */
public class MyClassLoader extends ClassLoader {

    public Class getClassFromFile(File nameFile) {
        byte[] bytes = new byte[(int) nameFile.length()];

        try (InputStream in = new FileInputStream(nameFile)) {
            while (in.read(bytes) > 0){

            }
//            in.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(null, bytes, 0, bytes.length);

    }
}
