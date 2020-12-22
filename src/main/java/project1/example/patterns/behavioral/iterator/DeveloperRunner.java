package project1.example.patterns.behavioral.iterator;

/**
 * DeveloperRunner
 *
 * @author "Andrei Prokofiev"
 */
public class DeveloperRunner {
    public static void main(String[] args) {
        String [] skills = {"Java", "Maven", "Spring"};
//        String [] skills = {};
                Developer developer = new Developer("Andrei", skills);
        Iterator iterator = developer.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
