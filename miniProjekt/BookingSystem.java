
import java.util.ArrayList;
import java.util.Scanner;

public class BookingSystem {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Course> courses = new ArrayList<Course>();
    public static ArrayList<Room> rooms = new ArrayList<Room>();

    public static Scanner scanner = new Scanner(System.in);

    private static int newestStudentId = 10;
    private static int newestCourseId = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            students.add(new Student("Peter", i));
        }

        //Group group = new Group(students);
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
                    createGroup();
                    pressEnter();
                    break;
                case 3:
                    System.out.println("3");
                    createCourse();
                    pressEnter();
                    break;
                case 4:
                    System.out.println("4");
                    addRoom();
                    pressEnter();
                    break;
                case 5:
                    System.out.println("5");
                    addStudentsToCourse();
                    pressEnter();
                    break;
                case 6:
                    System.out.println("6");
                    showStudents();
                    pressEnter();
                    break;
                case 7:
                    System.out.println("7");
                    showGroups();
                    pressEnter();
                    break;
                case 8:
                    System.out.println("8");
                    seeCourses();
                    pressEnter();
                    break;
                case 9:
                    System.out.println("9");
                    seeRooms();
                    pressEnter();
                    break;
                case 10:
                    System.out.println("10");

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
        Integer id = newestStudentId;
        newestStudentId++;

        return new Student(name, id);
    }

    public static void showStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void createCourse() {
        String title;
        String description;
    
        System.out.println("Provide course title:");
        title = scanner.nextLine();
        System.out.println("Provide course description:");
        description = scanner.nextLine();

        Course c = new Course(newestCourseId, title, description);

        courses.add(c);
        newestCourseId++;

        System.out.println(c.toString());
    }

    public static void addStudentsToCourse() {
        System.out.println("Select course:");
        seeCourses();

        Integer input = scanner.nextInt();
        scanner.nextLine();

        Course course = courses.get(input);

        showStudents();

        System.out.println("Input student id's in format (1,2,3,4,..):");
        String chosenIds = scan();

        String[] ids = chosenIds.split(",");
        ArrayList<Integer> intIds = new ArrayList<Integer>();
        for (String s : ids) {
            if (isNumeric(s)) {
                intIds.add(Integer.parseInt(s));
            } else {
                System.out.println("Invalid input: " + s);
                break;
            }
        }

        ArrayList<Student> s = new ArrayList<Student>();
        for (Integer integer : intIds) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() == integer) {
                    s.add(students.get(i));
                    students.get(i).addCourse(course);
                }
            }
        }

        course.addStudent(s);
        course.listStudents();
    }

    public static void seeCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ": " + courses.get(i).getTitle());
        }
    }

    public static void createGroup() {
        System.out.println("Choose course to create a group:");
        seeCourses();

        int choice = scanner.nextInt();
        scanner.nextLine();

        Course course = courses.get(choice);
        course.listStudents();

        System.out.println("Input id's in format (1,2,3,4,..), max 5 students:");
        String chosenIds = scan();

        String[] ids = chosenIds.split(",");
        ArrayList<Integer> intIds = new ArrayList<Integer>();
        for (String s : ids) {
            if (isNumeric(s)) {
                intIds.add(Integer.parseInt(s));
            } else {
                System.out.println("Invalid input: " + s);
                break;
            }
        }

        ArrayList<Student> s = new ArrayList<Student>();
        for (Integer integer : intIds) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() == integer) {
                    s.add(students.get(i));
                    students.get(i).addCourse(course);
                }
            }
        }

        Group g = new Group(s, course);
        course.addGroup(g);

        for (Student student : s) {
            student.addGroup(g);
        }
        g.toString();
    }

    public static void showGroups() {
        seeCourses();
        System.out.println("Choose course");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Course course = courses.get(choice);
        ArrayList<Group> groups = course.getGroups();

        for (Group group : groups) {
            System.out.println(group.toString());
        }
    }

    public static void addRoom() {
        System.out.println("Input room number:");
        String input = scanner.nextLine();

        Room room = new Room(input);
        rooms.add(room);
    }

    public static void seeRooms() {
        for (Room r : rooms) {
            System.out.println(r.toString());
        }
    }

    public static void reserveRoom() {
        System.out.println("Choose room to reserve");

        // Either i need to keep track of all groups created and choose from them,
        // or i do as i do other places and  go through the courses to find the groups
        System.out.println("Choose group for reservation");

        System.out.println("When shall the reservation start? (8:00 to 17:00 (Timeslots of 30 minute increments))");
        // Check if first time is within 8:00-16:30 such that you don't try and reserve 17:00 to 17:00.

        System.out.println("When shall the reservation end? (8:00 to 17:00 (Timeslots of 30 minute increments))");
        // Check that the given time is after the first time and within the reservation period.
        
        /* 
        If any of the checks fail notify the user
            out of range, 
            to short period, 
            wrong way around(9:00 - 8:00), 
            if another group has already reserved the room)
        */
    }

    public static int menu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        System.out.println("Choose one:");
        System.out.println(" 1. Create New Student");
        System.out.println(" 2. Create New Group");
        System.out.println(" 3. Create new Course");
        System.out.println(" 4. Add Room");
        System.out.println(" 5. Add student to course");
        System.out.println(" 6. See Students");
        System.out.println(" 7. See Groups");
        System.out.println(" 8. See Courses");
        System.out.println(" 9. See Rooms");
        System.out.println("10. Reserve Room");
        System.out.println(" 0. Quit");
        
        String input = scanner.nextLine();
        
        return isNumeric(input) ? Integer.parseInt(input) : -1;
    }
    
    public static String scan() {
        return scanner.nextLine();
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
