package lecture3;

public class point2D extends mathObj {
    int x;
    int y;
    public point2D() {}

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

    public double distance(point2D p) {
        return (Math.sqrt(Math.pow(this.x - p.getx(), 2) + Math.pow(this.y - p.gety(), 2)));
    }

    public static point2D create(int x, int y) {
        point2D temp = new point2D();
        temp.setx(x);
        temp.sety(y);

        return temp;
    }
}
