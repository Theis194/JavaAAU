package lecture8.Domain1;

/**
 * A class Point2D that represents a point in 2D space
 *
 * @author Gabriela Montoya
 * @version 1.2, 2023-10-03
 */
 
class Point2D {

    private final double x;
    private final double y;
   
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
   
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    public double distance(Point2D p) {
        double temp1 = this.x - p.x;
        double temp2 = this.y - p.y;
        return Math.sqrt((temp1*temp1)+(temp2*temp2));
    }
}