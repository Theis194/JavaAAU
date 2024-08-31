/**
 * A class Catalog that represents a collection of Courses implemented as a recursive
 * structure. The courses are ordered in the structure according to the title of the
 * course. 
 *
 * @author Gabriela Montoya
 * @version 1.5, 2023-11-03
 */
 
class Catalog {
    private Course c;
    private Catalog predecessors;
    private Catalog successors;    
    
    public Catalog(Course c) {
        this.c = c;
    }
    
    public Course search(String t) {
        int v = t.compareTo(c.getTitle());
        if (v == 0) {
            return c;
        } else if (v < 0 && predecessors != null) {
            return predecessors.search(t);
        } else if (successors != null) {
            return successors.search(t);
        } else {
            return null;
        }
    }
    
    public void addCourse(Course newCourse) {
        int v = newCourse.getTitle().compareTo(c.getTitle());
        if (v == 0) {
            
        } else if (v < 0) {
            if (predecessors != null) {
                predecessors.addCourse(newCourse);
            } else {
                predecessors = new Catalog(newCourse);    
            }
        } else if (successors != null) {
            successors.addCourse(newCourse);
        } else {
            successors = new Catalog(newCourse);    
        }    
    }
    
    public String toString() {
       
        return toString("");
    }

    public String inorder() {
        String str = "";
        if (predecessors != null) {
            str += predecessors.inorder();
        }
        str += c + "\n";
        if (successors != null) {
            str += successors.inorder();
        }
        return str;
    }
    
    private String toString(String t) {
        String str = t + c + "\n";
        if (predecessors != null) {
            str += predecessors.toString(t+"\t");
        }
        if (successors != null) {
            str += successors.toString(t+"\t");
        }
        return str;
   }
}