package project1.example.patterns.creational.fabrica;

import java.util.BitSet;

/**
 * Maing
 *
 * @author "Andrei Prokofiev"
 */

public class Main {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal dog = animalFactory.creat("Dog");
        Animal cat = animalFactory.creat("Cat");
        cat.voice();

        dog.voice();


        BitSet bitSet =new BitSet();

        bitSet.set(0,true);
        bitSet.set(1, false);
        System.out.println(bitSet.get(1));


    }
}
