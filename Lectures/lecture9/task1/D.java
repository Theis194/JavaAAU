/**
 * Which design patterns do classes A, B, C, D follow?
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */

import java.util.List;
import java.util.ArrayList;

class D extends B {
    private List<String> users =  new ArrayList<String>();

    public D(A a) {
        super(a);
    }
    
    public void m1() {
        String u = System.getProperty("user.name");
        users.add(u);
        super.m1();
    }
    public String toString() {
        return super.toString()+" "+users;
    }    
}