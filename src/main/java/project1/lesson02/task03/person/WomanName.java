package project1.lesson02.task03.person;

/**
 * WomanName
 * Класс представляет собой список женских имен.
 * @author Andrei_Prokofiev
 */
public enum WomanName {
    Anna("Anna"),
    Antonina("Antonina"),
    Bona("Bona"),
    Elena("Elena"),
    Inga("Inga"),
    Elsa("Elsa"),
    Sofia("Sofia");

    String name;

    WomanName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
