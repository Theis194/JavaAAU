/**
 * Which design patterns do classes A, B, C, D follow?
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */
 
class A {
    private int count = 0;
    
    public void m1() {
        this.count++;
    }
    
    public String toString() {
        return ""+count;
    }
}