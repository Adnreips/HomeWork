package project1.lesson05.task01;

import part1.lesson05.task01.person.Person;
import part1.lesson05.task01.pets.Pet;
import part1.lesson05.task01.pets.PetsComporator;

import java.util.*;

/**
 * Kartoteka
 * Класс, который имеет следующие методы:
 * - добавления питомца в общий список;
 * - поиск животного по его кличке;
 * - изменение данных животного по его идентификатору;
 * - вывод на экран списка животных в отсортированном порядке.
 *
 * @author Andrey
 */
public class Kartoteka {

    private Map<UUID, Pet> uuidPetMap = new HashMap<>();
    private Map<String, Set<Pet>> namePetsMap = new HashMap<>();

    public void putPet(Pet pet) {
        if (uuidPetMap.containsKey(pet.getId())) {
            throw new IllegalArgumentException("Вы пытаетесь вставить животное, которое уже присутствует в картотеке.");
        }
        uuidPetMap.put(pet.getId(), pet);
//        Set<Pet> petsByName = namePetsMap.get(pet.getNickname());
//        if (petsByName == null) {
//            petsByName = new HashSet<>();
//            namePetsMap.put(pet.getNickname(), petsByName);
//        }
        Set<Pet> petsByName = namePetsMap.computeIfAbsent(
                pet.getNickname(),
                k -> new HashSet<>());
        petsByName.add(pet);
    }

    public Map<UUID, Pet> getUuidPetMap() {
        return uuidPetMap;
    }

    public Map<String, Set<Pet>> getNamePetsMap() {
        return namePetsMap;
    }

    public void updatePet(UUID id, String nickname, Person person, int weight) {
        Pet pet = uuidPetMap.get(id);
        Set<Pet> petsByName = namePetsMap.get(pet.getNickname());
        if (namePetsMap != null) petsByName.remove(pet);
        pet.setWeight(weight);
        pet.setNickname(nickname);
        pet.setPerson(person);
        petsByName = namePetsMap.get(pet.getNickname());
        if (petsByName == null) {
            petsByName = new HashSet<>();
            namePetsMap.put(pet.getNickname(), petsByName);
        }
        petsByName.add(pet);
    }

    public Set<Pet> getPetsByNickname(String nickname) {
        Set<Pet> pets = namePetsMap.get(nickname);
        if (pets == null) {
            throw new IllegalArgumentException("Нет животного с именем: " + nickname);
        }
        return namePetsMap.get(nickname);
    }
    public void sortPetsAndPrints(){
        ArrayList<Pet> list = new ArrayList<>(uuidPetMap.values());
        Collections.sort(list, new PetsComporator<>());
        for (Pet p:list) {
            System.out.println(p);
        }
    }
}
