import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;

//import Reservation.WeekDay;

public class BookingSystem {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Room> rooms = new ArrayList<Room>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            students.add(createStudent("Peter", i));
        }

        Group group = new Group(students);
        System.out.println(group.toString());

        LocalTime start = LocalTime.of(8,0,0,0);
        LocalTime end = LocalTime.of(10,30,0,0);

        rooms.add(new Room(1));

        System.out.println(rooms.get(0).createReservation(group, WeekDay.MONDAY, start, end, 1));
        System.out.println(rooms.get(0).createReservation(group, WeekDay.MONDAY, start, end, 1));
        
        scanner.close();
    }

    public static Student createStudent(String name, Integer id) {
        return new Student(name, id);
    }

    public static Group createGroup(ArrayList<Student> students) {
        return new Group(students);
    }

    public static Group createGroup() {
        return new Group();
    }

    public static String scan() {
        return scanner.nextLine();
    }
}
