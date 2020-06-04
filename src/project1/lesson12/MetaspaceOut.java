package src.project1.lesson12;

import javassist.CannotCompileException;
import javassist.ClassPool;

import java.lang.reflect.InvocationTargetException;

/**
 * Metaspace
 * Программа демонстрирует ситуацию, когда ее выполнение
 * приводит к ошибке в Metaspace.
 * <p>
 * Для работы программы необходимо установить размер
 * Metaspace: -XX:MaxMetaspaceSize=512m.
 * <p>
 * Также необходимо подключить библиотеку: -javassist.jar.
 *
 * @author "Andrei Prokofiev"
 */
public class MetaspaceOut {
    public static void main(String[] args) throws CannotCompileException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        ClassPool pool = ClassPool.getDefault();
        int i = 0;

        while (true) {

            Class cc = pool.makeClass("MyClass" + i).toClass();

            i++;
        }
    }
}

