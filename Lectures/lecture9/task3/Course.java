/**
 * A class Course that represents a module with a code, title, and semesters
 *
 * @author Gabriela Montoya
 * @version 1.5, 2023-11-03
 */
 
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Course {
    private String code;
    private String title;
    private List<String> semesters;
    
    /**
     * Constructor that creates a course with the code and title given  
     * as parameters
     * @param code the code of the course
     * @param title the title of the course
     */    
    public Course (String code, String title) throws NullPointerException {
        this.code = code;
        this.title = title;
        this.semesters = new ArrayList<String>();
    }

    /**
     * an instance method that adds one semester to the course
     * @param semester the semester to add
     */    
    public void addSemester(String semester) {
        semesters.add(semester);
    }

    /**
     * an instance method that returns a string representation of the course
     * @return returns a string representation of the course
     */     
    @Override
    public String toString() {
        return code+","+title+","+semesters;
    }

    /**
     * an instance method that an iterator over the semesters of the course
     * @return returns an iterator over the semesters
     */        
    public Iterator<String> getSemesters() {
        return semesters.iterator();
    }

    /**
     * an instance method that returns the code of the course
     * @return returns the code of the course
     */        
    public String getCode() {
        return this.code;
    }

    /**
     * an instance method that returns the title of the course
     * @return returns the title of the course
     */        
    public String getTitle() {
        return this.title;
    }
    
    /**
     * an instance method that returns a boolean with value true iff the parameter 
     * represents the same instance as this
     * @return returns a boolean that is true if other and this represent the same instance
     * and false if they do not
     */     
    @Override
    public boolean equals(Object other)  {
        if (other == null || !(other instanceof Course)) {
            return false;
        }
        
        Course c2 = (Course) other;
        return code.equals(c2.code);
    }

    /**
     * an instance method that returns a copy of this (the copy only shares references to immutable objects
     * @return returns a course with the same code, title, and goals as this
     */     
    @Override
    public Course clone() {
        Course c = new Course (code, title);
        for (String s : semesters) {
            c.addSemester(s);
        }
        return c;
    }  
}