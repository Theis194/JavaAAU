package lecture8.Domain2;
/**
 * A class Room
 * that represents a bookable and identifiable room
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-20
 */
import java.util.ArrayList;

class Room implements Bookable, Identifiable<String> {
    private String id;
    private ArrayList<TimeSlot> bookedSlots;
    
    public Room(String id) {
        this.id = id;
        this.bookedSlots = new ArrayList<TimeSlot>();
    }
    
    public String getIdentifier() {
        return id;
    }
    
    public void book(TimeSlot ts) throws RoomAlreadyBookedException, BookingInThePastException {
        if (!available(ts)) {
            throw new RoomAlreadyBookedException("The room is already booked at "+ts);
        }
        
        if (ts.inThePast()) {
            throw new BookingInThePastException("The timeslot is in the past "+ts);
        }
        bookedSlots.add(ts);
    }
    
    public void cancel(TimeSlot ts) throws NonExistingBookingException {
        if (!bookedSlots.contains(ts)) {
            throw new NonExistingBookingException("A non existing booking cannot be cancelled");
        }
        bookedSlots.remove(ts);
    }
        
    public boolean available(TimeSlot ts) {

        return !bookedSlots.contains(ts);        
    }
}