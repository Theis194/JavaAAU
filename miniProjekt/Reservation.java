public class Reservation {
    public Group group;
    public WeekDay weekDay;
    public int priority;

    public Reservation(Group group, WeekDay weekDay, Integer priority ) {
        this.group = group;
        this.weekDay = weekDay;
        this.priority = priority;
    }
}

