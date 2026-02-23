package HMS;

public class Room {
    protected String roomId;
    protected boolean isAvailable;

    public Room(String roomId) {
        this.roomId = roomId;
        this.isAvailable = true;
    }

    public String getRoomId() {
        return roomId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class StandardRoom extends Room {
    public StandardRoom(String roomId) {
        super(roomId);
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomId) {
        super(roomId);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(String roomId) {
        super(roomId);
    }
}

class RoomNotFoundException extends Exception {
    public RoomNotFoundException(String message) {
        super(message);
    }
}
