package project1.example.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectRunner
 *
 * @author "Andrei Prokofiev"
 */
public class ProjectRunner {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = new DeveloperFactory();

        List<Developer> developers = new ArrayList<>();

        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("Java"));

        developers.add(developerFactory.getDeveloperBySpeciality("Java"));

        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("Java"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        for(Developer developer : developers){
            developer.writeCode();
        }


    }
}
