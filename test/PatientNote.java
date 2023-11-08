import java.time.LocalTime;
import java.util.ArrayList;

public class PatientNote extends Note {
    private String treatment;
    private Boolean ambulanceCalled;
    private Boolean advicedMedicalCare;
    private Boolean policeCase;

    public PatientNote() {
    }

    public PatientNote(ArrayList<String> notes, LocalTime timeStamp, String treatment,
                                              Boolean ambulanceCalled, Boolean advicedMedicalCare,
                                              Boolean policeCase){
    
           super(notes, timeStamp);
           this.treatment = treatment;
           this.ambulanceCalled = ambulanceCalled;
           this.advicedMedicalCare = advicedMedicalCare;
           this.policeCase = policeCase;
    }
}
