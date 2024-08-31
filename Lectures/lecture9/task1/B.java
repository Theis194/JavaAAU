/**
 * Which design patterns do classes A, B, C, D follow?
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */

abstract class B extends A{
    private A  a;
    
    public B(A a) {
        this.a = a;
    }

    public void m1() {
        a.m1();
    }
    
    public String toString() {
        return a.toString();
    }    
}