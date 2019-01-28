interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

class OrExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return (expression1.interpret(context) || expression2.interpret(context));
    }
}

class AndExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return (expression1.interpret(context) && expression2.interpret(context));
    }
}


public class InterpreterMain {
    public static void main(String[] args) {
        Expression cat = new TerminalExpression("cat");
        Expression black = new TerminalExpression("black");
        Expression isCatBlack = new AndExpression(cat, black);
        System.out.println(isCatBlack.interpret("black cat"));

        Expression dog = new TerminalExpression("dog");
        Expression green = new TerminalExpression("green");
        Expression isDogOrBlack = new OrExpression(dog, green);
        System.out.println(isDogOrBlack.interpret("green"));
        System.out.println(isDogOrBlack.interpret("rainbow"));


    }
}
