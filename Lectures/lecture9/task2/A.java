/**
 * Which design pattern does this class follow?
 *
 * @author Gabriela Montoya
 * @version 1.2, 2023-11-03
 */
 
import java.util.List;
import java.util.ArrayList;

class A {
   private String f1;
   private int f2;
   private List<A> f3 = new ArrayList<A>();
   
   public A(String f1, int f2) {
       this.f1 = f1;
       this.f2 = f2;
   }
   
   public void addA(A a) {
       this.f3.add(a);
   }
   
   public String toString() {
       
       return toString("");
   }
   private String toString(String t) {
       String str = t + f1 +"\t"+f2+"\n";
       for (A a : f3) {
           str += t + "\t"+a.toString(t+"\t");
       }
       return str;
   }
}