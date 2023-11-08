import java.util.ArrayList;
import java.time.LocalTime;

public class NotesTest {
    private static ArrayList<String> notes = new ArrayList<String>();

    private static String s;
    private static Boolean b;
    private static Integer i;
    private static LocalTime lt;

    public static void main(String[] args) {
        notes.add("a");
        notes.add("b");
        notes.add("c");

        LocalTime time = LocalTime.now();

        GeneralNote note1 = new GeneralNote(notes, time, "Shits lit!");
        GeneralNote note2 = new GeneralNote(notes, time, "Shits lit!!");
        GeneralNote note3 = new GeneralNote(notes, time, "Shits lit!!!");

        note1 = note1.update("args", true, note2, notes);

        System.out.println("note1: " + note1.toString());
        System.out.println("note1.previous: " + note1.getPrevious().toString());
    }
}
