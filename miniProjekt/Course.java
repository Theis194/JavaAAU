
import java.util.ArrayList;

public class Course {
    int courseId;
    String title;
    String description;
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Group> groups = new ArrayList<Group>();

    public Course (int _courseId, String _title, String _description) {
        courseId = _courseId;
        title = _title;
        description = _description;
    }

    public void addStudent(ArrayList<Student> _students) {
        students = _students;
    }

    public String getTitle() {
        return title;
    }

    public String listStudents() {
        String result = "";
        for (Student student : students) {
            result += student.toString();
        }
        return result;
    }

    public void addGroup(Group g) {
        groups.add(g);
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return String.format("Course{Title: %s, Description: %s}", this.title, this.description);
    }
}
