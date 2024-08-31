/**
 * Which design patterns do classes A, B, C, D follow?
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

class C extends B {
    private List<LocalTime> timestamps =  new ArrayList<LocalTime>();

    public C(A a) {
        super(a);
    }
    
    public void m1() {
        LocalTime lt = LocalTime.now();
        timestamps.add(lt);
        super.m1();
    }
    public String toString() {
        return super.toString()+" "+timestamps;
    }    
}