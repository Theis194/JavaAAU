# Exercise 1
Consider the following two snippets of code:

a.
``` java
try {
    int x = 100 / y;
    int[] es = new int[n];
    e = es[Math.round(x)];
} catch (ArithmeticException e1) {
    ...
} catch (NegativeArraySizeException e2) {
    ...
} catch (java.util.NoSuchElementException e3) {
    ...
}
```

b.
``` java
try {
    int x = 100 / y;
    int[] es = new int[n];
    e = es[Math.round(x)];
} catch (Exception e) {
    ...
} 
```

Which one would you use? Justify your answer.

There is three statements which could fail or throw an error. In snippet a there is a catch for each statement that could fail.
In snippet b there is a universal catch for every potential exception. 

I would prefer using snippet a because you can handle each exception differently and we can showcase the exception that occured. This is unclear in snippet b, BUT you could print the stacktrace, but this is not recommended for users(only coders).

In a case where we just want the exception stack trace and the exception message, b would be appliable(depending of the implementation of thrown exceptions).

# Exercise 2
(Chapter 13, exercise 13, [JavaFundamentals]) Complete the following snippet of code, so
the error message associated with the exception is printed on the standard output:

``` java
try {
    int x = 100 / 0;
} catch (ArithmeticException e) {
    String errorMessage = e./* You code goes here */;
    System.out.println(errorMessage);
}
```

``` java
try {
    int x = 100 / 0;
} catch (ArithmeticException e) {
    String errorMessage = e.message();
    System.out.println(errorMessage);
}
```

# Exercise 3
(Chapter 13, exercise 15, [JavaFundamentals]) Describe the reason why the following try-catch block does not compile:

``` java
try {
    // The following statement throws NumberFormatException
    int luckNumber = Integer.parseInt("Hello");
} catch (Exception e) {
    // Handle the exception here
} catch (NumberFormatException e) {
    // Handle the exception here
}
```
Because Exception is a super type of NumberFormatException the second catch block is never reached thus giving a compilation error.

# Exercise 4
Consider the following class:

``` java
class Point2D {
    private int x;
    private int y;
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public double distance(Point2D p) {
        int temp1 = this.x - p.x;
        int temp2 = this.y - p.y;
        return Math.sqrt((temp1*temp1)+(temp2*temp2));
    }
    public static Point2D create(int x, int y) {
        Point2D p = new Point2D();
        p.setX(x);
        p.setY(y);
        return p;
    }
}
```

Add a main method to this class that creates an instance of Point2D and invoke its methods.
Make sure that running the class Point2D throws an exception when invoking one of the
instance methods of the class. Notice that in this exercise you can’t modify the code of the
instance methods in the class, the only change in the class is the addition of a main method. 

(VIEW Point2D.java)

*Hint: in general, a call to a method could throw an exception during execution when certain
actual parameters are passed. The goal of this exercise is that you identify which of the given
methods could throw an exception and call that method with the appropriate actual
parameters to get an exception during execution.*

``` java 
package lecture6;
import com.sun.jdi.*;

public class Point2D {
    private int x;
    private int y;
    public void setX(int x) /* throws InvalidTypeException */{
        this.x = x;
    }

    public void setY(int y) /* throws InvalidTypeException */{
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public double distance(Point2D p) /* throws InvalidTypeException */ {
        int temp1 = this.x - p.x;
        int temp2 = this.y - p.y;
        return Math.sqrt((temp1*temp1)+(temp2*temp2));
    }
    public static Point2D create(int x, int y) /* throws InvalidTypeException */ {
        Point2D p = new Point2D();
        p.setX(x);
        p.setY(y);
        return p;
    }

    public static void main(String[] args) {
        Point2D p = new Point2D();
        Point2D p2 = new Point2D();
        
        int x1old = p.getX();
        int y1old = p.getY();
        System.out.println(x1old + "" + y1old);

        p.setX((Integer) null);
        p.setY(1);
        

        p2.setX(0);
        p2.setY(0);

        Point2D p3 = p.create(1,1);

        Double dist = p.distance(p2);
    }
}
```

# Exercise 5
Modify the method that threw an exception when you executed your class Point2D (from
the previous task). Add an appropriate throws clause to the method and code that
handles the exception in the main method. Notice that in this exercise you can’t modify
the code of the instance methods in the class, the only change in the instance methods is
the addition of a throws clause in the method declaration (before the body of the
method).

``` java
package lecture6;
import com.sun.jdi.*;

public class Point2D {
    private int x;
    private int y;
    public void setX(int x) throws NullPointerException{
        this.x = x;
    }

    public void setY(int y) throws NullPointerException{
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public double distance(Point2D p) throws NullPointerException{
        int temp1 = this.x - p.x;
        int temp2 = this.y - p.y;
        return Math.sqrt((temp1*temp1)+(temp2*temp2));
    }
    public static Point2D create(int x, int y) throws NullPointerException{
        Point2D p = new Point2D();
        p.setX(x);
        p.setY(y);
        return p;
    }

    public static void main(String[] args) {
        try {
            Point2D p = new Point2D();
            Point2D p2 = new Point2D();
            
            int x1old = p.getX();
            int y1old = p.getY();
            System.out.println(x1old + "" + y1old);
    
            p.setX((Integer) null);
            p.setY(1);
            
    
            p2.setX(0);
            p2.setY(0);
    
            Point2D p3 = p.create(1,1);
    
            Double dist = p.distance(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

# Exercise 6
Create a class that is a subtype of java.lang.Exception. This new type will represent the
abnormal condition “atempting to create a circle with a negative radius”. Decide if this
class should be a subtype of java.lang.RuntimeException. Modify the constructor of the
class Circle (available at Circle.java) to throw an instance of the class you have created
when the abnormal condition arises.

