package lecture3;
import java.util.Scanner;
import java.util.ArrayList;

public class pointsAndCircles {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<mathObj> points = new ArrayList<mathObj>();
    private static ArrayList<mathObj> circles = new ArrayList<mathObj>();

    public static void main(String[] args) {
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            mathObj obj = createMathObj(input);

            if (obj instanceof point2D) {
                points.add(obj);
                System.out.println("Point successfully created");
            } else if (obj instanceof circle) {
                circles.add(obj);
                System.out.println("Circle successfully created");
            } else {
                System.out.println("Invalid input!");
            }
        }
        scanner.close();
    }

    private static mathObj createMathObj(String input) {
        mathObj result = new mathObj();
        String[] temp = input.split(" ");
        if (temp.length == 3) {
            result = createPoint(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        } else if (temp.length == 4) {
            result =  createCircle(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Double.parseDouble(temp[3]));
        } else {
            return null;
        }

        return result;
    }

    private static point2D createPoint(int x, int y) {
        point2D point = new point2D();

        point.setx(x);
        point.sety(y);

        return point;
    }

    private static circle createCircle(int x, int y, double radius) {
        return new circle(x, y, radius);
    }
}
