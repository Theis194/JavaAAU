package lecture8.Domain2;
/**
 * A class RoomAlreadyBookedException 
 * that represents the abnormal condition of 
 * booking a busy room
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-10-20
 */
class RoomAlreadyBookedException extends RuntimeException {
    public RoomAlreadyBookedException() {
        
    }
    
    public RoomAlreadyBookedException(String msg) {
        super(msg);
    }    

    public RoomAlreadyBookedException(String msg, Throwable cause) {
        super(msg, cause);
    }    

    public RoomAlreadyBookedException(Throwable cause) {
        super(cause);
    }        
}