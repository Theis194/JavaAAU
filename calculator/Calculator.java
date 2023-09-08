import java.util.*;
import Expression.*;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Type anything");
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        scanner.close();

        String[] parts = text.split(" ");
        if (parts.length >= 3) {
            return;
        }
        Expression myExpression = new Expression(parts);

        System.out.println(myExpression.calculate());
    }
}
