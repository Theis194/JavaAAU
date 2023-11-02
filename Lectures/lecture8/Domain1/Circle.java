package lecture8.Domain1;

/**
 * A class Circle that represents circles in 2D space
 *
 * @author Gabriela Montoya
 * @version 1.5, 2023-10-27
 */
class Circle extends Shape {

    private final double radius;
  
    public Circle (double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    } 

    @Override    
    public double perimeter() {
        return 2* Math.PI * radius;
    }

    @Override  
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }   

    @Override
    public Point2D getClosestPoint(Point2D other) {

        double distance = Shape.distancePoints(getX(), getY(), other.getX(), other.getY())-this.radius;
        double pointDistance = Shape.distancePoints(getX(), getY(), other.getX(), other.getY());
        double angle = Math.acos(Math.abs(getX() - other.getX())/pointDistance);
        int signX = other.getX()>this.getX()?-1:1;
        int signY = other.getY()>this.getY()?-1:1;
        double xdelta = Math.cos(angle)*distance;
        double ydelta = Math.sin(angle)*distance;
        return new Point2D(other.getX()+signX*xdelta, other.getY()+signY*ydelta);
    }

    @Override  
    public String toString() {
        return "Circle c=("+getX()+", "+getY()+") r="+radius;
    }
    
    @Override   
    public double distance(Shape s) {
        Point2D p = s.getClosestPoint(new Point2D(getX(), getY()));
        return Shape.distancePoints(getX(), getY(), p.getX(), p.getY())-this.radius;      
    }
}
