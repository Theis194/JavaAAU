package expression;

public class Expression {
    public Double a;
    public Double b;
    public String operator;

    public Expression(Expression A, Expression B, String Operator) {
        this.a = A.calculate();
        this.b = B.calculate();
        this.operator = Operator;
    }

    public Expression(Double A, Expression B, String Operator) {
        this.a = A;
        this.b = B.calculate();
        this.operator = Operator;
    }
    
    public Expression(Expression A, Double B, String Operator) {
        this.a = A.calculate();
        this.b = B;
        this.operator = Operator;
    }

    public Expression(Double A, Double B, String Operator) {
        this.a = A;
        this.b = B;
        this.operator = Operator;
    }

    public Double calculate() {
        Double result = 0.0;

        switch (this.operator) {
            case "+":
                return this.a + this.b;
            case "-":
                return this.a - this.b;
            case "*":
                return this.a * this.b;
            case "/":
                return this.a / this.b;
            default:
                System.out.printf("Operator: \"%s\" not supported", operator);
                break;
        }        

        return result;
    }
}
