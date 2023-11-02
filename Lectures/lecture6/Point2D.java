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
