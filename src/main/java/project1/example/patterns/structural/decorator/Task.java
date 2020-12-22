package project1.example.patterns.structural.decorator;

/**
 * Task
 *
 * @author "Andrei Prokofiev"
 */
public class Task {
    public static void main(String[] args) {
//        Developer developer = new JavaTeamLeadDeveloper(new SeniorJavaDeveloper(new JavaDeveloper()));
        Developer developer = new SeniorJavaDeveloper(new JavaDeveloper());

        System.out.println(developer.makeJob());
    }
}
