import java.util.ArrayList;

public class Group {
    public ArrayList<Student> students = new ArrayList<Student>();
    public Integer priorityHours = 4;
    public Course course;
    
    public Group(ArrayList<Student> students, Course _course) {
        this.students = students;
        this.course = _course;
    }

    public Group() {}

    public void add(Student newStudent) {
        this.students.add(newStudent);
    }

    public void setCourse(Course _course) {
        course = _course; 
    }

    @Override
    public String toString() {
        String temp = "Group{";
        for (int i = 0; i < students.size(); i++) {
            if (i == students.size() - 1) {
                temp += students.get(i).toString();
                temp += "}";
                return temp;
            }
            temp += students.get(i).toString() + ",";
            temp += "\n";
        }
        return temp;
    }
}
