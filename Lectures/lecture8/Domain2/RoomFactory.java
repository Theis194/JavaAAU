package lecture8.Domain2;

public class RoomFactory {
    public static Room createRoom(Type type, String id) {
        Room room = null;
        switch (type) {
            case SEMINARROOM:
                room = new SeminarRoom(id);
                break;
            case MEETINGROOM:
                room = new MeetingRoom(id);
                break;
            case GROUPROOM:
                room = new GroupRoom(id);
                break;
            default:
                break;
        }
        return room;
    }
}
