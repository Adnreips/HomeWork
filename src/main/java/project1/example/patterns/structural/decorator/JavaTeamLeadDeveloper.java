package project1.example.patterns.structural.decorator;

/**
 * JavaTeamLeadDeveloper
 *
 * @author "Andrei Prokofiev"
 */
public class JavaTeamLeadDeveloper extends DeveloperDecorator {

    public JavaTeamLeadDeveloper(Developer developer) {
        super(developer);
    }

    public String sendWeekReport(){
        return "Send week report to customer";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }
}
