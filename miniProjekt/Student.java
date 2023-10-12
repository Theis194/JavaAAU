import java.util.ArrayList;

public class Student {
    String name;
    Integer id;
    ArrayList<Course> enroledCourses = new ArrayList<Course>();
    ArrayList<Group> groups = new ArrayList<Group>();
    
    public Student (String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public void addCourse(Course c) {
        enroledCourses.add(c);
    }

    public void addGroup(Group g) {
        groups.add(g);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Student{Name: %s, Id: %d}", name, id);
    }
}
