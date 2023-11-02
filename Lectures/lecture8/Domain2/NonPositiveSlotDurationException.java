package lecture8.Domain2;
/**
 * A class NonPositiveSlotDurationException 
 * that represents the abnormal condition of 
 * having a non positive slot duration 
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-20
 */
class NonPositiveSlotDurationException extends RuntimeException {
    
    public NonPositiveSlotDurationException() {
        
    }
    
    public NonPositiveSlotDurationException(String msg) {
        super(msg);
    }    

    public NonPositiveSlotDurationException(String msg, Throwable cause) {
        super(msg, cause);
    }    

    public NonPositiveSlotDurationException(Throwable cause) {
        super(cause);
    }        
}