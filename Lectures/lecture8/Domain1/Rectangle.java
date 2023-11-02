package lecture8.Domain1;
import java.util.ArrayList;

/**
 * A class Rectangle that represents rectangle in 2D space
 *
 * @author Gabriela Montoya
 * @version 1.3, 2023-10-27
 */


class Rectangle extends Shape {

    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
  
    public Rectangle(double x1, double y1, double x2, double y2) {
        super((x1+x2)/2, (y1+y2)/2);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
         return x1; 
    }
    
    public double getY1() {
         return y1; 
    }

    public double getX2() {
         return x2; 
    }

    public double getY2() {
         return y2; 
    }

    @Override
    public double perimeter() {
        return 2*(x2-x1) + 2*(y2-y1);
    }

    @Override  
    public double area() {
        return 2*(x2-x1)*(y2-y1);
    }   

    @Override    
    public String toString() {
        return "Rectangle ("+x1+", "+y1+") ("+x2+", "+y2+")";
    } 

    @Override  
    public Point2D getClosestPoint(Point2D other) {
        ArrayList<Point2D> points = new ArrayList<Point2D>();
        if (x1 <= other.getX() && other.getX() <= x2) {
            points.add(new Point2D(other.getX(), y1));
            points.add(new Point2D(other.getX(), y2));
        }
        if (y1 <= other.getY() && other.getY() <= y2) {
            points.add(new Point2D(x1, other.getY()));
            points.add(new Point2D(x2, other.getY()));
        }
        addVertices(points);
            
        return getClosestPoint(points, other);
        
    }

    private void addVertices(ArrayList<Point2D> points) {
        Point2D lb = new Point2D(x1, y1);
        Point2D lu = new Point2D(x1, y2);
        Point2D ru = new Point2D(x2, y2);
        Point2D rb = new Point2D(x2, y1);
        points.add(lb);
        points.add(lu);
        points.add(ru);
        points.add(rb);
    }

    private Point2D getClosestPoint(ArrayList<Point2D> points, Point2D other) {
        double dist = Double.MAX_VALUE;
        Point2D closest = null;
        for (Point2D v : points) {
            if (v.distance(other)<dist) {
                dist = v.distance(other);
                closest = v;
            }
        }
        return closest;
    }

    @Override    
    public double distance(Shape other) {

        throw new UnsupportedOperationException("the method distance has not "
          + "been implemented in the class Rectangle yet");
    }  

    @Override    
    public boolean overlaps(Shape other) {

        throw new UnsupportedOperationException("the method overlaps has not "
          + "been implemented in the class Rectangle yet");        
    }
}

