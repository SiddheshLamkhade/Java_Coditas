package HMS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import HMS.Model.Guest;
import HMS.Model.GuestManager;

public class ReservationManager {
    private List<Reservation> reservations = new ArrayList<>();
    private GuestManager guestManager;
    private RoomManager roomManager;

    public ReservationManager(GuestManager guestManager, RoomManager roomManager) {
        this.guestManager = guestManager;
        this.roomManager = roomManager;
    }

    public void makeRoomReservation(String reservationId, String guestId, Date date, String roomId) throws InvalidReservationException, GuestNotFoundException, RoomNotFoundException {
        if (date == null || guestId == null || roomId == null) {
            throw new InvalidReservationException("Invalid reservation data.");
        }
        boolean guestExists = false;
        for (Guest g : guestManager.getGuests()) {
            if (g.getGuestId().equals(guestId)) {
                guestExists = true;
                break;
            }
        }
        if (!guestExists) {
            throw new GuestNotFoundException("Guest not found: " + guestId);
        }
        Room room = roomManager.findRoom(roomId);
        if (!room.isAvailable()) {
            throw new InvalidReservationException("Room is not available.");
        }
        roomManager.updateAvailability(roomId, false);
        reservations.add(new RoomReservation(reservationId, guestId, date, roomId));
    }

    public void makeEventHallReservation(String reservationId, String guestId, Date date, String hallId) throws InvalidReservationException, GuestNotFoundException {
        if (date == null || guestId == null || hallId == null) {
            throw new InvalidReservationException("Invalid reservation data.");
        }
        boolean guestExists = false;
        for (Guest g : guestManager.getGuests()) {
            if (g.getGuestId().equals(guestId)) {
                guestExists = true;
                break;
            }
        }
        if (!guestExists) {
            throw new GuestNotFoundException("Guest not found: " + guestId);
        }
        reservations.add(new EventHallReservation(reservationId, guestId, date, hallId));
    }

    public void makeSpaReservation(String reservationId, String guestId, Date date, String spaId) throws InvalidReservationException, GuestNotFoundException {
        if (date == null || guestId == null || spaId == null) {
            throw new InvalidReservationException("Invalid reservation data.");
        }
        boolean guestExists = false;
        for (Guest g : guestManager.getGuests()) {
            if (g.getGuestId().equals(guestId)) {
                guestExists = true;
                break;
            }
        }
        if (!guestExists) {
            throw new GuestNotFoundException("Guest not found: " + guestId);
        }
        reservations.add(new SpaReservation(reservationId, guestId, date, spaId));
    }

    public void cancelReservation(String reservationId) throws InvalidReservationException, RoomNotFoundException {
        Reservation toRemove = null;
        for (Reservation r : reservations) {
            if (r.getReservationId().equals(reservationId)) {
                toRemove = r;
                break;
            }
        }
        if (toRemove == null) {
            throw new InvalidReservationException("Reservation not found: " + reservationId);
        }
        if (toRemove instanceof RoomReservation) {
            RoomReservation rr = (RoomReservation) toRemove;
            roomManager.updateAvailability(rr.getRoomId(), true);
        }
        reservations.remove(toRemove);
    }
}
