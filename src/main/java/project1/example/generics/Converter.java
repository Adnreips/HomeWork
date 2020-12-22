package project1.example.generics;


/**
 * Converter
 *
 * @author "Andrei Prokofiev"
 */

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}