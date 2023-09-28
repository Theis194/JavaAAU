import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;

public class BookingSystem {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Room> rooms = new ArrayList<Room>();

    public static Scanner scanner = new Scanner(System.in);

    private static int newestId = 10;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            students.add(new Student("Peter", i));
        }

        Group group = new Group(students);
        //System.out.println(group.toString());
        while (true) {
            int selected = menu();
            if (selected == 0) {
                break;
            }
            switch (selected) {
                case 1:
                    System.out.println("1");
                    students.add(createStudent());
                    pressEnter();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    showStudents();
                    pressEnter();
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                case 7:
                    System.out.println("7");
                    break;
                default:
                    System.out.println("Invalid input!");
                    pressEnter();
                    break;
            }
        }
        scanner.close();

        /* LocalTime start = LocalTime.of(8,0,0,0);
        LocalTime end = LocalTime.of(10,30,0,0);

        rooms.add(new Room(1));

        System.out.println(rooms.get(0).createReservation(group, WeekDay.MONDAY, start, end, 1));
        System.out.println(rooms.get(0).createReservation(group, WeekDay.MONDAY, start, end, 1)); */
        
    }

    public static Student createStudent() {
        System.out.println("Input name");
        String name = scan();
        Integer id = newestId;
        newestId++;

        return new Student(name, id);
    }

    public static void showStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static Group createGroup() {
        return new Group();
    }

    public static String scan() {
        return scanner.nextLine();
    }

    public static int menu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 

        System.out.println("Choose one:");
        System.out.println("1. Create New Student");
        System.out.println("2. Create New Group");
        System.out.println("3. Add Room");
        System.out.println("4. See Students");
        System.out.println("5. See Groups");
        System.out.println("6. See Rooms");
        System.out.println("7. Reserve Room");
        System.out.println("0. Quit");
        
        String input = scanner.nextLine();

        return isNumeric(input) ? Integer.parseInt(input) : -1;
    }

    public static void pressEnter() {
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
