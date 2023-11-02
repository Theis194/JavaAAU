package lecture8.Domain2;

public class Test {
    public static void main(String[] args) {
        Room gr = RoomFactory.createRoom(Type.GROUPROOM,"ben");
        Room mr = RoomFactory.createRoom(Type.MEETINGROOM,"yes");
        Room sr = RoomFactory.createRoom(Type.SEMINARROOM,"no");


        
    }
}