package src.project1.lesson11.task01;

/**
 * MyException
 *Класс представляет собой наследника непроверяемого исключения,
 *которое бросается в случае возникновение ошибки программы.
 * @author Andrei_Prokofiev
 */

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
