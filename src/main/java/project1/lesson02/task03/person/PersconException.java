package project1.lesson02.task03.person;

/**
 * PersonGenerator
 * Класс представляет собой пользовательское исключение с конструктором с одним параметром типа String.
 * @author Andrei_Prokofiev
 */
public class PersconException extends IllegalArgumentException {
    public PersconException(String message) {
        super(message);
    }
}
