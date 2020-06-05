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
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {


        return super.loadClass(name);

    }


    @Override
    protected Class<?> findClass(String name) {

        File file = new File(name);

        byte[] bytes = new byte[(int) file.length()];

        try (InputStream in = new FileInputStream(name)) {
            while (in.read(bytes) > 0){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(null, bytes, 0, bytes.length);
    }


}
