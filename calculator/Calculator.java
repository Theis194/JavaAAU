import java.util.*;
import expression.*;
import java.util.regex.*;

public class Calculator {
    private static String[] knownOperators = {"+", "-", "*", "/"};

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

    public static void main(String[] args) {
        LinkedList<Double> numbers = new LinkedList<Double>();
        LinkedList<String> operators = new LinkedList<String>();

        System.out.println("Type anything");
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        scanner.close();

        numbers = getNumbers(text);
        operators = getOperator(text);
        if (numbers.size() < 2 && operators.size() < 1 && numbers.size() != operators.size() + 1) {
            System.out.printf("Invalid expression \"%s\"", text);
            return;
        }
        

        Double result = evaluateExpression(numbers, operators);

        System.out.printf("Result: %f", result);
    }

    private static Double evaluateExpression(LinkedList<Double> numbers, LinkedList<String> operators) {
        if (numbers.size() < 1) {
            return -1.0;
        } else if (numbers.size() == 1) {
            return numbers.get(0);
        }

        int hihestSignificance = getHighestSignificance(operators);

        Expression expression = new Expression(numbers.get(hihestSignificance), numbers.get(hihestSignificance + 1), operators.get(hihestSignificance));
        numbers.remove(hihestSignificance + 1);
        numbers.remove(hihestSignificance);
        operators.remove(hihestSignificance);
        
        numbers.add(hihestSignificance, expression.calculate());

        return evaluateExpression(numbers, operators);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isOperator(String character) {

        if (character == null) {
            return false;
        }
        for (String operator : knownOperators) {
            if (character.equals(operator)) {
                return  true;
            }
        }
        return false;
    }

    private static LinkedList<Double> getNumbers(String input) {
        LinkedList<Double> result = new LinkedList<Double>();
        if (input == null || input.isEmpty()) {
            return result;
        }

        String regex = "[-+]?[0-9]*\\.?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String matchedNumber = matcher.group();
            result.add(Double.parseDouble(matchedNumber));
        }

        return result;
    }

    private static LinkedList<String> getOperator(String input) {
        LinkedList<String> result = new LinkedList<String>();
         if (input.length() == 0 || input == null) {
            return result;
        }

        String[] temp = input.split("");
        for (String string : temp) {
            if (isOperator(string)) {
                result.add(string);
            }
        }
        return result;
    }

    private static int getOperatorValue(String operator) {
        switch (operator) {
            case "+":
                return OperatorSignificance.ADD.getValue();
            case "-":
                return OperatorSignificance.SUBTRACT.getValue();
            case "*":
                return OperatorSignificance.MULTIPLY.getValue();
            case "/":
                return OperatorSignificance.DIVIDE.getValue();
            default:
                System.out.printf("Operator: \"%s\" not supported", operator);
                return -1;
        }
    }

    // Returns index of the highest significance
    private static  int getHighestSignificance( LinkedList<String> operators) {
        if(operators.size() < 1) {
            return -1;
        }
        
        if (operators.size() == 1) {
            return 0;
        }

        int highestSignificance = -1;
        int highestSignificanceIndex = -1;
        for (int i = 0; i < operators.size(); i++) {
            int operatorValue = getOperatorValue(operators.get(i));
            if (operatorValue > highestSignificance) {
                highestSignificance = operatorValue;
                highestSignificanceIndex = i;
            }
        }
        return highestSignificanceIndex;
    }
}
