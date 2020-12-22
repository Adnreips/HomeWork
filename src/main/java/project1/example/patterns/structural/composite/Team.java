package project1.example.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Team
 *
 * @author "Andrei Prokofiev"
 */
public class Team {
    List<Developer> developers = new ArrayList<>();

    public void addDeveloper(Developer developer){
        developers.add(developer);
    }

    public void createProject(){

        System.out.println("Developers write: ");
        for (Developer developer : developers) {
            developer.writeCode();

        }
    }
}
