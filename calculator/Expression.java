package calculator;

public class Expression {
    public int a;
    public int b;
    public String operator;

    public Expression(String[] parts) {
        this.a = Integer.parseInt(parts[0]);
        this.b = Integer.parseInt(parts[2]);
        this.operator = parts[1];
    }

    public int calculate() {
        int result;

        switch (this.operator) {
            case "+":
                return this.a + this.b;
                break;
            case "-":
                return this.a - this.b;
                break;
            case "*":
                return this.a * this.b;
                break;
            case "/":
                return this.a / this.b;
                break;
            default:
                System.out.print("Operator: \"%s\" not supported", operator);
                break;
        }        

        return result;
    }
}
