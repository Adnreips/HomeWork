package project1.lesson02.task03.person;

/**
 * ManName
 * Класс представляет собой список мужских имен.
 *
 * @author Andrei_Prokofiev
 */
public enum ManName {
    Andrey("Andrey"),
    Anton("Anton"),
    Boris("Boris"),
    Egor("Egor"),
    Ivan("Ivan"),
    Igor("Igor"),
    Sergey("Sergey");

    String name;

    ManName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
