import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;

public class Room {
    public static HashMap<Integer, HashMap<Integer, Reservation>> week = new HashMap<Integer, HashMap<Integer, Reservation>>();
    public static Integer roomNumber;

    public static void setup() {
        week.put(0, new HashMap<Integer, Reservation>());
        week.put(1, new HashMap<Integer, Reservation>());
        week.put(2, new HashMap<Integer, Reservation>());
        week.put(3, new HashMap<Integer, Reservation>());
        week.put(4, new HashMap<Integer, Reservation>());
    }

    public Room(Integer roomNum) {
        setup();
        roomNumber = roomNum;
    }

    public Boolean createReservation(Group group, WeekDay weekDay, LocalTime startTime, LocalTime endTime, int priority) {
        Integer wDay = weekDay.getValue();
        HashMap<Integer, Reservation> day = week.get(wDay);

        Duration duration = (Duration.between(startTime, endTime));
        Long reservationCount = duration.toMinutes() / 30;
        Integer start = startTime.minusHours(8).getHour() * 2 + startTime.getMinute() == 30 ? 1 : 0;
        
        for (int i = 0; i < reservationCount; i++) {
            if (day.get(start + i) != null || day.get(start + i) != null ? day.get(start + i).priority <= priority : false) {
                return false;
            }
        }

        for (int i = 0; i < reservationCount; i++) {
            Reservation reservation = new Reservation(group, weekDay, priority);
            day.put(start + i, reservation);
        }
        return true;
    }
}
