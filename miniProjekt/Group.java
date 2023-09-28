import java.util.ArrayList;

public class Group {
    public ArrayList<Student> students = new ArrayList<Student>();
    public Integer priorityHours = 4;
    
    public Group(ArrayList<Student> students) {
        this.students = students;
    }

    public Group() {}

    public void add(Student newStudent) {
        this.students.add(newStudent);
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
