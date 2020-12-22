package project1.example.patterns.structural.composite;




/**
 * Project
 *
 * @author "Andrei Prokofiev"
 */
public class Project {
    public static void main(String[] args) {
        Team team = new Team();
        Developer firstJavaDeveloper = new JavaDeveloper();
        Developer secondtJavaDeveloper = new JavaDeveloper();
        Developer firstCppDeveloper = new CppDeveloper();

        team.addDeveloper(firstJavaDeveloper);
        team.addDeveloper(secondtJavaDeveloper);
        team.addDeveloper(firstCppDeveloper);

        team.createProject();


    }
}
