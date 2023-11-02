package lecture8.Domain2;
/**
 * An interface Bookable
 * that represents entities that can be booked
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-20
 */
interface Bookable {
    void book(TimeSlot ts) throws RoomAlreadyBookedException, BookingInThePastException;
    void cancel(TimeSlot ts) throws NonExistingBookingException;
    boolean available(TimeSlot ts);
}