package project1.example.patterns.behavioral.interpretator;

/**
 * InterpreterRunner
 *
 * @author "Andrei Prokofiev"
 */
public class InterpreterRunner {

    public static void main(String[] args) {

        Expression isJava = getJavaExpression();
        Expression isJavaEE = getJavaEEExpression();
        System.out.println("Does developer knows Java Core: "+ isJava.interpret("Java Core"));
        System.out.println("Does developer knows Java EE: " + isJavaEE.interpret("Java Spring"));

    }
    public static Expression getJavaExpression(){
        Expression expression = new TerminalExpression("Java");
        Expression expression1 = new TerminalExpression("Java Core");
        return new OrExpression(expression, expression);

    }
    public static Expression getJavaEEExpression(){
        Expression java = new TerminalExpression("Java");
        Expression spring = new TerminalExpression("Spring");
        return new AndExpression(java, spring);

    }


}
