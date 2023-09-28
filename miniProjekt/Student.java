public class Student {
    String name;
    Integer id;
    
    public Student (String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Student{Name: %s, Id: %d}", name, id);
    }
}
