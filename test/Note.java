import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Note {
    private Integer id;
    private ArrayList<String> notes;
    private LocalTime timeStamp;

    public Note() {
    }

    public Note(ArrayList<String> notes, LocalTime timeStamp) {
        this.notes = notes;
        this.timeStamp = timeStamp;
    }

    public Note(String note, LocalTime timeStamp) {
        notes.add(note);
        this.timeStamp = timeStamp;
    }

    //  Gettters
    public ArrayList<String> getNotes() {
        return this.notes;
    }

    public Integer getId() {
        return this.id;
    }
    
    public LocalTime getTimeStamp() {
        return this.timeStamp;
    }
    
    // Setters
    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }
    public  void settimeStam(LocalTime timeStamp){
        this.timeStamp=timeStamp;
    }
}
