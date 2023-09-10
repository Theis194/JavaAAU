import java.util.*;
import expression.*;
import expression.Number;

import java.util.regex.*;

public class Calculator {
    private static String[] knownOperators = {"+", "-", "*", "/", "^"};
    public static Scanner scanner = new Scanner(System.in);

    // Main method handling the functionality of the calculator
    public static void main(String[] args) {
        while (true) {
            LinkedList<Expression> numbers = new LinkedList<Expression>();
            LinkedList<Operator> operators = new LinkedList<Operator>();
    
            String text = getInput();
            if (text.equals("q")) {
                break;
            }
    
            numbers = getNumbers(text);
            operators = getOperator(text);
            if (numbers.size() < 2 || operators.size() < 1 || numbers.size() != operators.size() + 1) {
                System.out.printf("Invalid expression \"%s\"", text);
                continue;
            }
    
            Expression result = createExpression(numbers, operators, getHighestSignificance(operators));
    
            System.out.println("Result: ");
            System.out.printf("Result: %.5f \n", result.evaluate());
        }
        scanner.close();
    }

    // Waits for input from the console
    private static String getInput() {
        System.out.println("Input Equation");
        return scanner.nextLine();
    }

    // Recursively builds an expression based on a list of numbers and operators
    public static Expression createExpression( LinkedList<Expression> numbers, LinkedList<Operator> operators, int index) {
        if (index == -1) {
            return numbers.get(0);
        }
        Calculation calc = new Calculation(numbers.get(index), numbers.get(index + 1), operators.get(index));

        numbers.remove(index + 1);
        numbers.remove(index);
        operators.remove(index);

        numbers.add(index, calc);

        index = getHighestSignificance(operators);
        return createExpression(numbers, operators, index);
    }

    // Returns true if the given string is a number
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

    // Returns true if the given character is one of the known operators
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

    // This method extracts all raw numbers from a text string
    private static LinkedList<Expression> getNumbers(String input) {
        LinkedList<Expression> result = new LinkedList<Expression>();
        if (input == null || input.isEmpty()) {
            return result;
        }

        String regex = "[0-9]*\\.?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String matchedNumber = matcher.group();
            result.add(new Number(Double.parseDouble(matchedNumber)));
        }
        return result;
    }

    // This method extracts all operators from a given text string
    private static LinkedList<Operator> getOperator(String input) {
        Boolean inParentheses = false;
        LinkedList<Operator> result = new LinkedList<Operator>();
         if (input.length() == 0 || input == null) {
            return result;
        }

        String[] temp = input.split("");
        for (String string : temp) {
            if (string.equals("(")) {
                inParentheses = true;
            } else if(string.equals(")")) {
                inParentheses = false;
            }
            if (isOperator(string)) {
                result.add(new Operator(string, inParentheses));
            }
        }
        return result;
    }

    // Returns index of the highest significance
    private static  int getHighestSignificance( LinkedList<Operator> operators) {
        if(operators.size() < 1) {
            return -1;
        }
        
        if (operators.size() == 1) {
            return 0;
        }

        int highestSignificance = -1;
        int highestSignificanceIndex = -1;
        for (int i = 0; i < operators.size(); i++) {
            int operatorValue = operators.get(i).significance;
            if (operatorValue > highestSignificance) {
                highestSignificance = operatorValue;
                highestSignificanceIndex = i;
            }
        }
        return highestSignificanceIndex;
    }
}
