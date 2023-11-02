 package lecture8.Domain1;

public class ShapeFactory {
    public  Shape createShape(Type type, double... params ) {
        Shape shape = null;
        switch (type) {
            case RECTANGLE:
                shape = new Rectangle(params[0], params[1], params[2], params[3]);
                break;
            case CIRCLE:
            shape = new Circle(params[0], params[1], params[2]);
                break;
            default:
                break;
        }
        return shape;
    }
}
