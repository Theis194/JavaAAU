package lecture8.Domain2;
/**
 * A class BookingInThePastException 
 * that represents the abnormal condition of 
 * booking something in the past
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-20
 */
class BookingInThePastException extends RuntimeException {
    
    public BookingInThePastException() {
        
    }
    
    public BookingInThePastException(String msg) {
        super(msg);
    }    

    public BookingInThePastException(String msg, Throwable cause) {
        super(msg, cause);
    }    

    public BookingInThePastException(Throwable cause) {
        super(cause);
    }        
}