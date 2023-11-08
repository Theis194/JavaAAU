import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GeneralNote extends Note {
    private String task;
    private Boolean completed;
    private GeneralNote previous;
    
    public GeneralNote(){
    }

    public GeneralNote(ArrayList<String> notes, LocalTime timeStamp, String task){
        super(notes, timeStamp);
        this.task = task;
        this.completed = false;
        this.previous = null;
    }

    public GeneralNote update(Object... params) {
        GeneralNote gn = new GeneralNote();
        for (Object object : params) {
            if (object instanceof String) {
                System.out.println("String");
                gn.setTask((String) object);
            } else if (object instanceof Boolean) {
                System.out.println("Boolean");
                gn.setCompleted((Boolean) object);
            } else if (object instanceof List) {
                ArrayList<String> temp = (ArrayList<String>) object;
                if (temp.get(0) instanceof String) {
                    System.out.println("String List");
                    gn.setNotes(temp);
                }
            } else if (object instanceof LocalTime) {
                System.out.println("LocalTime");
                gn.settimeStam((LocalTime) object);
            } else {
                System.out.println("not supported");
            }
        }
        gn.setPreviousGN(this);

        return gn;
    }

     // GETTERS 
     public String getTask(){
        if (this.task.equals(null)) {
            return previous.getTask();
        }
        return this.task;
    }
    
    public Boolean getCompleted() {
        if (this.completed.equals(null)) {
            return previous.getCompleted();
        }
        return this.completed;
    }

    @Override
    public ArrayList<String> getNotes() {
        if (super.getNotes().equals(null)) {
            return previous.getNotes();
        }
        return super.getNotes();
    }

    @Override
    public LocalTime getTimeStamp() {
        if (super.getTimeStamp() == null) {
            return previous.getTimeStamp();
        }
        return super.getTimeStamp();
    }

    public GeneralNote getPrevious() {
        return this.previous;
    }
    
    // Setters
    public void setTask(String task){
        this.task = task;
    }
    
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setPreviousGN(GeneralNote gn) {
        this.previous = gn;
    }

    @Override
    public String toString() {
        String n = "";
        for (String s : this.getNotes()) {
            n += s + ", ";
        }
        return String.format("Notes: %s TimeStamp: %s, Task: %s, Completed: %b", n, this.getTimeStamp().toString(), this.getTask(), this.getCompleted());
    }
}
