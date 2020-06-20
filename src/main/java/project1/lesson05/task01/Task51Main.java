package project1.lesson05.task01;

import part1.lesson05.task01.person.Person;
import part1.lesson05.task01.person.Sex;
import part1.lesson05.task01.pets.Cat;
import part1.lesson05.task01.pets.Pet;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

/**
 * Task51Main
 * Класс выполняет основные методы, которые присутствует в классах Person, Pet,
 * Kartoteka. Создает картотеку и выполняет действия над ней.
 * @author Andrey
 */
public class Task51Main {
    public static void main(String[] args) {

        Person person1 = new Person(28, Sex.MALE, "Petr");
        Person person2 = new Person(27, Sex.FEMALE, "Ulia");
        Person person3 = new Person(22, Sex.FEMALE, "Elena");
        Person person4 = new Person(23, Sex.MALE, "Erema");

        Pet pet1 = new Pet(UUID.randomUUID(),"Vaska", person1, 10);
        Pet pet2 = new Pet(UUID.randomUUID(),"Murzik", person2, 20);
        Pet pet3 = new Pet(UUID.randomUUID(),"Borka", person2, 20);
        Pet pet4 = new Pet(UUID.randomUUID(),"Bobik", person3, 30);
        UUID uuid = UUID.randomUUID();
        Pet pet5 = new Pet(uuid,"Boss", person4, 30);
        Pet pet6 = new Pet(uuid,"Boss", person4, 30);
        Pet pet7 = new Pet(UUID.randomUUID(),"Borka", person2, 20);
        Pet pet8 = new Cat(UUID.randomUUID(),"Borka", person2, 20);

        Kartoteka kartoteka = new Kartoteka();
        kartoteka.putPet(pet1);
        kartoteka.putPet(pet2);
        kartoteka.putPet(pet3);
        kartoteka.putPet(pet4);
        kartoteka.putPet(pet5);
        kartoteka.putPet(pet7);
        kartoteka.putPet(pet8);

        try {
            kartoteka.putPet(pet6);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

        System.out.println("Данные из картотеки: ");
        Iterator itr = kartoteka.getNamePetsMap().entrySet().iterator();
        while (itr.hasNext()) System.out.println(itr.next());
        System.out.println();

        System.out.println("Данные из картотеки: ");
        Iterator itr6 = kartoteka.getUuidPetMap().entrySet().iterator();
        while (itr6.hasNext()) System.out.println(itr6.next());
        System.out.println();




        System.out.println("Поиск животного по кличке: ");
        try{
            Set<Pet> pets = kartoteka.getPetsByNickname("Bora");
            Iterator itr3 = pets.iterator();
            while (itr3.hasNext()) System.out.println(itr3.next());
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

        System.out.println("Изменение данных о животном по идентификатору (Vaska на Robik, person1 на person4, " +
                "вес с 10 на 40): ");
        System.out.println("было: ");
        System.out.println(pet1);

        kartoteka.updatePet(pet1.getId(),"Robik", person4, 40 );
        System.out.println("стало: ");
        System.out.println(pet1);

        System.out.println("Сортируем и выводим на экран животных из картотеки: ");
        kartoteka.sortPetsAndPrints();

    }

}
