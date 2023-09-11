package expression;

public class Operator extends Expression {
    public String operator;
    public int significance;

    public Operator(String _operator, int parentheses) {
        this.operator = _operator;
        this.significance = getOperatorValue(_operator, parentheses);
    }

    // Funny enum things
    // Each enum is a function with a specified value
    // You can then call 
    public enum OperatorSignificance {
        ADD(0),
        SUBTRACT(1),
        MULTIPLY(2),
        DIVIDE(3),
        POWER(4),
        SQRT(5);

        private final int value;
        OperatorSignificance(final int newValue) {
            value = newValue;
        }

        public int getValue() {return value; }
    }

    // Returns a numerical value representing the significance of the mathematical operator
    private static int getOperatorValue(String operator, int parentheses) {
        int parenthesesExtra = 10;
        int significanceValue = 0;
        switch (operator) {
            case "+":
                significanceValue = OperatorSignificance.ADD.getValue();
                break;
            case "-":
                significanceValue = OperatorSignificance.SUBTRACT.getValue();
                break;
            case "*":
                significanceValue = OperatorSignificance.MULTIPLY.getValue();
                break;
            case "/":
                significanceValue = OperatorSignificance.DIVIDE.getValue();
                break;
            case "^":
                significanceValue = OperatorSignificance.POWER.getValue();
                break;
            case "sqrt":
                significanceValue = OperatorSignificance.SQRT.getValue();
                break;
            default:
                System.out.printf("Operator: \"%s\" not supported", operator);
                significanceValue = -1;
                break;
            }
            return significanceValue + (parentheses * parenthesesExtra);
    }
}