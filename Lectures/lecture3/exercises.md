# Exercise 1
What is the output of the following code?

``` java
public class Employee {
String name;
boolean retired;
double salary;
public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.println(emp.name);
        System.out.println(emp.retired);
        System.out.println(emp.salary);
    }
}
```

It prints the default values of String(null), Boolean(false), and double 0.0

# Exercise 2
Create a class named Point2D with two int instance variables named x and y.
``` java
public class Point2D {
    int x;
    int y;
    public Point2D() {}

    public void setx(int x) {
        this.x = x;
    }

    public void setx(int y) {
        this.y = y;
    }

    public int getx() {
        return this.x;
    }

    public int getx() {
        return this.y;
    }
}
```

# Exercise 3
Implement a method named distance in the
Point2D class that you created in the previous exercise. The method accepts an instance
of the Point2D class and returns the distance between the current point and the point
represented by the parameter. The method should be declared as follows:

``` java
public class Point2D {
    /* Code from the previous exercise goes here. */
    public double distance(Point2D p) {
        /* Your code for this exercise goes here. */
    }
}
```

``` java
public class Point2D {
    int x;
    int y;
    public Point2D() {}

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public double distance(Point2D p) {
        return (math.sqrt(math.pow(this.x - p.getx(), 2) + math.pow(this.y - p.gety(), 2)))
    }
}
```

# Exercise 4
Enhance the Point2D class by adding a statc
factory method named create(). A factory method in a class is used to create objects of
the class. The create() method should be declared as follows:

``` java
public class Point2D {
    /* Code from the previous exercise goes here. */
    public static Point2D create(int x, int y) {
        /* Your code for this exercise goes here. */
    }
}
```

``` java
public class Point2D {
    int x;
    int y;
    public Point2D() {}

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public double distance(Point2D p) {
        return (math.sqrt(math.pow(this.x - p.getx(), 2) + math.pow(this.y - p.gety(), 2)))
    }

    public static Point2D create(int x, int y) {
        Point2D temp = new Point2D();
        temp.setx(x);
        temp.sety(y);

        return tmep;
    }
}
```

# Exercise 5
What will be the output when the following PassByValueTest class is run?

``` java
// PassByValueTest.java
package com.jdojo.cls.excercise;
public class PassByValueTest {
    public static void main(String[] args) {
        int x = 100;
        System.out.println("x = " + x);
        change(x);
        System.out.println("x = " + x);
        Point2D p = new Point2D();
        p.setX(40);
        p.setY(60);
        System.out.println("p.x = " + p.getX() + ", p.y = " + p.getY());
        changePointReference(p);
        System.out.println("p.x = " + p.getX() + ", p.y = " + p.getY());
        changePoint(p);
        System.out.println("p.x = " + p.getX() + ", p.y = " + p.getY());
    }

    public static void change(int x) {
        x = 200;
    }

    public static void changePointReference(Point2D p) {
        p = new Point2D();
    }

    public static void changePoint(Point2D p) {
        int newX = p.getX() / 2;
        int newY = p.getY() / 2;
        p.setX(newX);
        p.setY(newY);
    }
}
```

Since this isn't pass by value the p received in the changePointReference() is not the same as the original p, it is but a copy of it. So in this case all the println would look the same

# Exercise 6
Create a Circle class that has three private
final instance variables named x, y, and radius. The x and y instance variables represent
the x and y coordinates of the center of the circle; they are of int data type. The radius
instance variable represents the radius of the circle; it is of the double data type. Add a
constructor to the Circle class that accepts the values for its instance variables x, y, and
radius. Add geters for the three instance variables.

``` java
public class circle() {
    private int x;
    private int y;
    private double radius;

    public circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public setx(int x) {
        this.x = x;
    }

    public sety(int y) {
        this.y = y
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }
}
```

# Exercise 7
Enhance the Circle class by adding four
instance methods named centerDistance, distance, overlaps, and touches. All
these methods accept a Circle as a parameter. The centerDistance method returns
the distance (as a double) between the centers of the circle and another circle passed in
as the parameter. The distance method returns the minimum distance (as a double)
between the two circles. If two circles overlap, the distance method returns a negative
number. The overlaps method returns true if two circles overlap and false otherwise.
The touches method returns true if two circles touch each other and false otherwise.
The distance method must use the centerDistance method. The body of the
overlaps and touches methods must contain only one statement that uses the distance
method.

``` java
public class circle() {
    private int x;
    private int y;
    private double radius;

    public circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public setx(int x) {
        this.x = x;
    }

    public sety(int y) {
        this.y = y
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public double centerDistance(Circle circle) {
        return (Math.sqrt(Math.pow(this.x - circle.x, 2)) + (Math.pow(this.y - circle.y, 2)));
    }

    public double distance(Circle circle) {
        return centerDistance(circle) - radius - circle.radius;
    }

    public boolean overlaps(Circle circle) {
        return distance(circle) < 0;
    }

    public boolean touches(Circle circle) {
        return distance(circle) == 0;
    }
}
```

# Exercise 8
Enhance the Circle class by adding two
methods named perimeter and area that compute and return the perimeter and area
of the circle, respectively

``` java
public class circle() {
    private int x;
    private int y;
    private double radius;

    public circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public setx(int x) {
        this.x = x;
    }

    public sety(int y) {
        this.y = y
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public double centerDistance(Circle circle) {
        return (Math.sqrt(Math.pow(this.x - circle.x, 2)) + (Math.pow(this.y - circle.y, 2)));
    }

    public double distance(Circle circle) {
        return centerDistance(circle) - radius - circle.radius;
    }

    public boolean overlaps(Circle circle) {
        return distance(circle) < 0;
    }

    public boolean touches(Circle circle) {
        return distance(circle) == 0;
    }

    public double perimiter() {
        return (2 * this.radius) * Math.pi;
    }

    public double area() {
        return Math.pi * Math.pow(this.radius, 2)    
    }
}
```

# Exercise 9
Add a second constructor to the Circle
class that takes a double parameter, which is the radius of the circle. This constructor
should call another existing constructor of the Circle class with three parameters passing
zero as the values for x and y.

``` java
public class circle() {
    private int x;
    private int y;
    private double radius;

    public circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public circle(double radius) {
        this(0, 0, radius);
    }

    public setx(int x) {
        this.x = x;
    }

    public sety(int y) {
        this.y = y
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public double centerDistance(Circle circle) {
        return (Math.sqrt(Math.pow(this.x - circle.x, 2)) + (Math.pow(this.y - circle.y, 2)));
    }

    public double distance(Circle circle) {
        return centerDistance(circle) - radius - circle.radius;
    }

    public boolean overlaps(Circle circle) {
        return distance(circle) < 0;
    }

    public boolean touches(Circle circle) {
        return distance(circle) == 0;
    }

    public double perimiter() {
        return (2 * this.radius) * Math.pi;
    }

    public double area() {
        return Math.pi * Math.pow(this.radius, 2)    
    }
}
```

# Exercise 10
Explain your answer to exercise 5 in detail.

# Exercise 11
Did you use the keyword this in the definition of the class Circle? If you used it, was it
necessary? Why?

The way i made the definition of circle i had to use this because the constructor parameters and the class variabels had the same name

# Exercise 12
Write a method contains that determines if an instance of the Point2D class passed as
parameter is contained by the current instance of Circle. This method returns true if
the point is contained in the circle and false otherwise. In which of the classes will the
new method be included? Justify your choice.

``` java
public class circle() {
    private int x;
    private int y;
    private double radius;

    public circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public circle(double radius) {
        this(0, 0, radius);
    }

    public setx(int x) {
        this.x = x;
    }

    public sety(int y) {
        this.y = y
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public double centerDistance(Circle circle) {
        return (Math.sqrt(Math.pow(this.x - circle.x, 2)) + (Math.pow(this.y - circle.y, 2)));
    }

    public double distance(Circle circle) {
        return centerDistance(circle) - radius - circle.radius;
    }

    public boolean overlaps(Circle circle) {
        return distance(circle) < 0;
    }

    public boolean touches(Circle circle) {
        return distance(circle) == 0;
    }

    public double perimiter() {
        return (2 * this.radius) * Math.pi;
    }

    public double area() {
        return Math.pi * Math.pow(this.radius, 2)    
    }

    public boolean contains(point2D p) {
        return Math.sqrt(Math.pow(this.x - p.getx, 2) + Math.pow(this.y - p.gety, 2)) <= this.radius;
    }
}
```

# Exercise 13
Write a program that allows for creating circles and points (using the classes created in the
previous exercises). The program must allow the user to create any number of circles or
points in any order and store the circles and points in a suitable data structure (some
options are arrays, java.util.ArrayList, java.util.Vector,
java.util.LinkedList).

``` java
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
```

# Exercise 14
