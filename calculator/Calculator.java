import java.util.*;
import expression.*;
import expression.Number;
import java.util.regex.*;

public class Calculator {
    private static String[] knownOperators = {"+", "-", "*", "/", "^", "sqrt"};
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
            if (numbers.size() < 1 || operators.size() < 1) {
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

        Calculation calc;
        if (operators.get(index).operator.equals("sqrt")) {
            calc = new Calculation(numbers.get(index), operators.get(index));
            numbers.remove(index);
            operators.remove(index);
        } else {
            calc = new Calculation(numbers.get(index), numbers.get(index + 1), operators.get(index));
            numbers.remove(index + 1);
            numbers.remove(index);
            operators.remove(index);
        }

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
        int parentheses = 0;
        LinkedList<Operator> result = new LinkedList<Operator>();
         if (input.length() == 0 || input == null) {
            return result;
        }

        LinkedList<String> temp = new LinkedList<String>();

        // Using a regex pattern to split the input string into (+,-,*,/,sqrt(),(,)) and numbers
        Pattern pattern = Pattern.compile("sqrt\\([^)]+\\)|[()+*/^-]|\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            temp.add(matcher.group());
        }

        for (String string : temp) {
            if (string.equals("(")) {
                parentheses++;
            } else if (string.equals(")")) {
                parentheses--;
            } else if (string.contains("sqrt(")) {
                string = string.split("\\(")[0];
            }
            if (isOperator(string)) {
                result.add(new Operator(string, parentheses));
            }
        }
        return result;
    }

    // Returns index of the highest significance
    private static  int getHighestSignificance( LinkedList<Operator> operators) {
        if(operators.size() < 1) {
            return -1;
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
