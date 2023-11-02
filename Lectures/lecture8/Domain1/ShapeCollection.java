package lecture8.Domain1;

/**
 * A class ShapeCollection that stores a number of shapes (circles
 * and rectangles) and can display some statistics
 *
 * @author Gabriela Montoya
 * @version 1.4, 2023-10-27
 */
 
import java.util.Scanner;
import java.util.ArrayList;

class ShapeCollection {

    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private ShapeFactory factory = new ShapeFactory();

    public void addCircle(double x, double y, double r) {
        Circle c = (Circle)factory.createShape(Type.CIRCLE, x, y, r);
        shapes.add(c);
    }
    
    public void addRectangle(double x1, double y1, double x2, double y2) {
        Rectangle r = (Rectangle)factory.createShape(Type.RECTANGLE, x1, y1, x2, y2);
        shapes.add(r);        
    }
    
    public int getNumberOfShapes() {
        return shapes.size();
    }
        
    public double getTotalArea() {
        double total = 0.0;
        for (int i = 0; i < shapes.size(); i++) {
            Shape si = shapes.get(i);
            total += si.area();
        }
        return total;
    }   

    public double getLargestArea() {
        double largest = 0.0;
        for (int i = 0; i < shapes.size(); i++) {
            Shape si = shapes.get(i);
            double area = si.area();
            if (area > largest) {
                largest = area;
            }
        }
        return largest;
    }   

    public double getSmallestArea() {
        double smallest = Double.MAX_VALUE;
        for (int i = 0; i < shapes.size(); i++) {
            Shape si = shapes.get(i);
            double area = si.area();
            if (area < smallest) {
                smallest = area;
            }
        }
        return smallest;
    }

    public static void showOptions() {

        System.out.println("\nWhat do you want to do?\n");
        System.out.println("1. Create a circle");
        System.out.println("2. Create a rectangle");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
    }

    public static int getOption() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
  
    public static void handle(int option, ShapeCollection sc) {
        switch(option) {
            case 1:
                createCircle(sc);
                break;
            case 2:
                createRectangle(sc);
                break;
            case 3:
                printStats(sc);
        }        
    }
    public static void createCircle(ShapeCollection sc) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the x coordinate of the circle's center (double): ");
        double x = input.nextDouble();
        System.out.print("Enter the y coordinate of the circle's center (double): ");
        double y = input.nextDouble();        
        System.out.print("Enter the radius of the circle (double): ");
        double r = input.nextDouble();
        sc.addCircle(x, y, r);        
    }    
    
    public static void createRectangle(ShapeCollection sc) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the x coordinate of the left-most lower vertex of the rectangle (double): ");
        double x1 = input.nextDouble();
        System.out.print("Enter the y coordinate of the left-most lower vertex of the rectangle (double): ");
        double y1 = input.nextDouble();
        System.out.print("Enter the x coordinate of the right-most higher vertex of the rectangle (double): ");
        double x2 = input.nextDouble();
        System.out.print("Enter the y coordinate of the right-most higher vertex of the rectangle (double): ");
        double y2 = input.nextDouble();        
        sc.addRectangle(x1, y1, x2, y2);        
    }
    
    public static boolean interact(ShapeCollection sc) {
        boolean keepInteracting = true;
        showOptions();
        int option = getOption();
        if (option >= 1 && option <= 3) {
            handle(option, sc);
        } else if (option == 4) {
            keepInteracting = false;
        } else {
            System.out.println("Invalid option, please try again!");  
        }
        return keepInteracting;
    }
    
    public static void printStats(ShapeCollection sc) {
        System.out.println("Number of shapes: "+sc.getNumberOfShapes());
        System.out.println("Total area: "+sc.getTotalArea());
        System.out.println("The largest area: "+sc.getLargestArea());
        System.out.println("The smallest area: "+sc.getSmallestArea());                        
    }
    
    public static void main(String[] args) {
        ShapeCollection sc = new ShapeCollection();
        while (interact(sc)){ 
            
        }
    }
}
