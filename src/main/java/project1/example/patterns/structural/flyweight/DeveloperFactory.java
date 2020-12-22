package project1.example.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * DeveloperFactory
 *
 * @author "Andrei Prokofiev"
 */
public class DeveloperFactory {
    private static final Map<String, Developer> developers = new HashMap<>();

    public Developer getDeveloperBySpeciality(String speciality) {

        Developer developer = developers.get(speciality);
        String speciality1 = speciality.toLowerCase();
        if (developer == null) {
            switch (speciality1) {
                case "java":
                    System.out.println("Hiring java developer");
                    developer = new JavaDeveloper();
                    break;
                case "c++":
                    System.out.println("Hiring C++ developer");
                    developer = new CppDeveloper();

            }
            developers.put(speciality, developer);

        }
        return developer;

    }

}
