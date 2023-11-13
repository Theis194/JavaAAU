/**
 * A Main class that uses the class A 
 *
 * @author Gabriela Montoya
 * @version 1.2, 2023-11-03
 */
 
class Main {
    public static void main(String[] args) {
    
        A a1 = new A("j", 0);
        A a2 = new A("a", 3);
        A a3 = new A("m", 4);
        A a4 = new A("n", 34);
        a2.addA(a4);
        a1.addA(a2);
        a1.addA(a3);
        System.out.println(a1);
    }
}