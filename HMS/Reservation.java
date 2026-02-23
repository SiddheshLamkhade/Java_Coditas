package HMS;

import java.util.Date;

public abstract class Reservation {
    protected String reservationId;
    protected String guestId;
    protected Date reservationDate;

    public Reservation(String reservationId, String guestId, Date reservationDate) {
        this.reservationId = reservationId;
        this.guestId = guestId;
        this.reservationDate = reservationDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestId() {
        return guestId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }
}

class RoomReservation extends Reservation {
    private String roomId;
    public RoomReservation(String reservationId, String guestId, Date reservationDate, String roomId) {
        super(reservationId, guestId, reservationDate);
        this.roomId = roomId;
    }
    public String getRoomId() {
        return roomId;
    }
}

class EventHallReservation extends Reservation {
    private String hallId;
    public EventHallReservation(String reservationId, String guestId, Date reservationDate, String hallId) {
        super(reservationId, guestId, reservationDate);
        this.hallId = hallId;
    }
    public String getHallId() {
        return hallId;
    }
}

class SpaReservation extends Reservation {
    private String spaId;
    public SpaReservation(String reservationId, String guestId, Date reservationDate, String spaId) {
        super(reservationId, guestId, reservationDate);
        this.spaId = spaId;
    }
    public String getSpaId() {
        return spaId;
    }
}

class InvalidReservationException extends Exception {
    public InvalidReservationException(String message) {
        super(message);
    }
}

class GuestNotFoundException extends Exception {
    public GuestNotFoundException(String message) {
        super(message);
    }
}
