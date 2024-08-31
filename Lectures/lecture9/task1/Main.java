/**
 * A Main class that uses the classes A, C, D 
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */
 
class Main {
    public static void main(String[] args) {
        A a = new A();
        a = new C(a);
        a = new D(a);
        a.m1();
        a.m1();
        a.m1();        
        System.out.println(a.toString());
    }
}