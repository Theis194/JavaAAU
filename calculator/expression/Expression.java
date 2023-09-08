package expression;

public class Expression {
    public Double value = null;
    public Expression(){

    }
    
    public Double evaluate() {
        System.out.println("Expr!");
        return this.value;
    }
}
