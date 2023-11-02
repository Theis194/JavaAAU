package lecture8.Domain2;
/**
 * A class NonExistingBookingException 
 * that represents the abnormal condition of 
 * performing an operation over a booking that does not exist
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-20
 */
class NonExistingBookingException extends RuntimeException {
    public NonExistingBookingException() {
        
    }
    
    public NonExistingBookingException(String msg) {
        super(msg);
    }    

    public NonExistingBookingException(String msg, Throwable cause) {
        super(msg, cause);
    }    

    public NonExistingBookingException(Throwable cause) {
        super(cause);
    }        
}