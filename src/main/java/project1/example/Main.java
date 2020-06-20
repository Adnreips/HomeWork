package project1.example;

import project1.lesson8.task01.realization.Person;

/**
 * Main
 *
 * @author Andrey
 */
public class Main {

    public static void main(String[] args) {
        new Main().doWork();
    }

    private void doWork() {

        Person personVasya = new Person(12, "Vasya");

        SuperBox<Object> boxObject = new SuperBox<>();
        boxObject.internalVariable = new Object();

        SuperBox<Person> boxPerson = new SuperBox<>();
//        boxPerson.internalVariable = new Object(); // ТАК НЕЛЬЗЯ

        boxPerson.internalVariable = personVasya;
//        doWithPerson(boxPerson);


        boxObject.internalVariable = personVasya; // ТАК МОЖНО ЭТО НУЖНО ПОНЯТЬ

//        boxObject = boxPerson; // ТАК НЕЛЬЗЯ ЭТО НУЖНО ПОНЯТЬ, ссылке присвоить существующую ссылку параметризованного класса нельзя, а новую сделать можно
        boxObject.internalVariable = new Object();

//        boxPerson = boxObject; // ТАК НЕЛЬЗЯ ЭТО НУЖНО ПОНЯТЬ
    }


    private void doWithPerson(SuperBox<Person> box){
        //box.object хочу узнать возраст
    }
}
