package project1.example.patterns.creational.builder;

/**
 * Main
 *
 * @author "Andrei Prokofiev"
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Director director = new Director();

        director.setBuilder(new VisitCardWebsitBuilder());
        Website website = director.buildWebsite();
        System.out.println(website);
    }
}
