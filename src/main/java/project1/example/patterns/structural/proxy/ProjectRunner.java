package project1.example.patterns.structural.proxy;

/**
 * ProjectRunner
 *
 * @author "Andrei Prokofiev"
 */
public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new ProxyProject("https://www.github.com/adnreips");
        project.run();
    }
}
