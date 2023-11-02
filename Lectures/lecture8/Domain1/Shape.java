package lecture8.Domain1;
/**
 * An abstract class Shape that represents the concept of a shape
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-03
 */
abstract class Shape {

    private final double x;
    private final double y;
  
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }
  
    public double getX() {
        return this.x;
    }
  
    public double getY() {
        return this.y;
    }
  
    /**
     * an instance method that finds a point in the shape that is closest to
     * a given point
     *
     * @param other the given point
     * 
     * @return Returns a Point2D instance that is in the shape and is the 
     *         closest to other
     *
     */    
    public abstract Point2D getClosestPoint(Point2D other);
  
    public double centerDistance(Shape other) {
        return Shape.distancePoints(this.x, this.y, other.x, other.y);
    }
    
    public abstract double distance(Shape other);

    public boolean overlaps(Shape other) {
        return this.distance(other) < 0;
    }
  
    public abstract double perimeter();
  
    public abstract double area();
  
    public static double distancePoints(double x1, double y1, double x2, double y2) {
        double distX = x2 - x1;
        double distY = y2 - y1;
      
        return Math.sqrt((distX*distX)+(distY*distY));
    }
}