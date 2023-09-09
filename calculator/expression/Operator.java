package expression;

public class Operator extends Expression {
    public String operator;
    public int significance;

    public Operator(String _operator, Boolean inParentheses) {
        this.operator = _operator;
        this.significance = getOperatorValue(_operator, inParentheses);
    }

    // Funny enum things
    // Each enum is a function with a specified value
    // You can then call 
    public enum OperatorSignificance {
        ADD(0),
        SUBTRACT(1),
        MULTIPLY(2),
        DIVIDE(3);

        private final int value;
        OperatorSignificance(final int newValue) {
            value = newValue;
        }

        public int getValue() {return value; }
    }

    // Returns a numerical value representing the significance of the mathematical operator
    private static int getOperatorValue(String operator, Boolean inParentheses) {
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
            default:
                System.out.printf("Operator: \"%s\" not supported", operator);
                significanceValue = -1;
                break;
            }
            if (inParentheses == true) {
                significanceValue += parenthesesExtra;
            }
            return significanceValue;
    }
}