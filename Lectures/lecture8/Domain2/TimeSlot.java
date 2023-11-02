package lecture8.Domain2;
/**
 * A class TimeSlot
 * that represents a time slot
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-20
 */
import java.time.LocalDateTime;
import java.time.Duration;

class TimeSlot {
    
    LocalDateTime start;
    Duration duration;
    
    public TimeSlot(LocalDateTime s, Duration d) throws NonPositiveSlotDurationException {
        if (d.isZero() || d.isNegative()) {
            throw new NonPositiveSlotDurationException("The duration must be positive");
        }
        this.start = s;
        this.duration = d;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof TimeSlot)) {
            return false;
        }
        TimeSlot other = (TimeSlot) o;
        
        return start.equals(other.start) && duration.equals(other.duration);
    }
    
    public boolean overlaps(TimeSlot other) {
        return !other.start.plus(other.duration).isBefore(this.start)
               &&
               !this.start.plus(duration).isBefore(other.start);
    }
    
    public boolean inThePast() {
        return start.isBefore(LocalDateTime.now());
    }
}