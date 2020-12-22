package project1.example.patterns.behavioral.interpretator;

/**
 * AndExpression
 *
 * @author "Andrei Prokofiev"
 */
public class AndExpression implements Expression {
    Expression expression1;
    Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}
