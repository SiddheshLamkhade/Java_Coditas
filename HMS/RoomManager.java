package HMS;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> rooms = new ArrayList<>();

    public RoomManager() {
        // Sample rooms
        rooms.add(new StandardRoom("R101"));
        rooms.add(new DeluxeRoom("R201"));
        rooms.add(new SuiteRoom("R301"));
    }

    public Room findRoom(String roomId) throws RoomNotFoundException {
        for (Room room : rooms) {
            if (room.getRoomId().equals(roomId)) {
                return room;
            }
        }
        throw new RoomNotFoundException("Room not found: " + roomId);
    }

    public void viewRooms() {
        System.out.println("--- Room List ---");
        for (Room room : rooms) {
            System.out.println(room.getRoomId() + " | Available: " + room.isAvailable());
        }
    }

    public void updateAvailability(String roomId, boolean available) throws RoomNotFoundException {
        Room room = findRoom(roomId);
        room.setAvailable(available);
    }
}
