public enum WeekDay {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4);

    private final int value;
    WeekDay(final int newValue) {
        value = newValue;
    }

    public int getValue() {return value; }
}
