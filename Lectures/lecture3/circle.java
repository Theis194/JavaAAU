package lecture3;

public class circle extends mathObj {
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

    public double centerDistance(circle circle) {
        return (Math.sqrt(Math.pow(this.x - circle.x, 2)) + (Math.pow(this.y - circle.y, 2)));
    }

    public double distance(circle circle) {
        return centerDistance(circle) - radius - circle.radius;
    }

    public boolean overlaps(circle circle) {
        return distance(circle) < 0;
    }

    public boolean touches(circle circle) {
        return distance(circle) == 0;
    }

    public double perimiter() {
        return (2 * this.radius) * Math.PI;
    }

    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public boolean contains(point2D p) {
        return Math.sqrt(Math.pow(this.x - p.getx(), 2) + Math.pow(this.y - p.gety(), 2)) <= this.radius;
    }
}
