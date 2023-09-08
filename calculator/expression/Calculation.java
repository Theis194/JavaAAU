package expression;

public class Calculation extends Expression {
    public Expression a;
    private Double aVal = null;

    public Expression b;
    private Double bVal = null;

    public String operator;

    public Calculation(Expression A, Expression B, String Operator) {
        this.a = A;
        this.b = B;
        this.operator = Operator;
        this.aVal = A.value;
        this.bVal = B.value;
    }

    public Calculation(Calculation A, Calculation B, String Operator) {
        this.a = A;
        this.b = B;
        this.operator = Operator;
        this.aVal = A.evaluate();
        this.bVal = B.evaluate();
    }

    public Calculation(Number A, Number B, String Operator) {
        this.a = A;
        this.b = B;
        this.operator = Operator;
        this.aVal = A.value;
        this.bVal = B.value;
    }

    public Calculation(Number A, Calculation B, String Operator) {
        this.a = A;
        this.b = B;
        this.operator = Operator;
        this.aVal = A.value;
        this.bVal = B.evaluate();
    }

    public Calculation(Calculation A, Number B, String Operator) {
        this.a = A;
        this.b = B;
        this.operator = Operator;
        this.aVal = A.evaluate();
        this.bVal = B.value;
    }

    @Override public Double evaluate() {
        Double result = 0.0;

        if (aVal == null) {
            this.aVal = this.a.evaluate();
        }
        if (bVal == null) {
            this.bVal = this.b.evaluate();
        }

        switch (this.operator) {
            case "+":
                return this.aVal + this.bVal;
            case "-":
                return this.aVal - this.bVal;
            case "*":
                return this.aVal * this.bVal;
            case "/":
                return this.aVal / this.bVal;
            default:
                System.out.printf("Operator: \"%s\" not supported", operator);
                break;
        }        

        return result;
    }
}
