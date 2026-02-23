package HMS;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String guestId;
    private String name;
    private String contactDetails;

    public Guest(String guestId, String name, String contactDetails) {
        this.guestId = guestId;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    @Override
    public String toString() {
        return "Guest ID: " + guestId + ", Name: " + name + ", Contact: " + contactDetails;
    }
}

class GuestManager {
    private List<Guest> guests = new ArrayList<>();

    public void addGuest(Guest guest) throws InvalidGuestException {
        if (guest == null || guest.getGuestId() == null || guest.getName() == null || guest.getContactDetails() == null) {
            throw new InvalidGuestException("Guest data is invalid.");
        }
        for (Guest g : guests) {
            if (g.getGuestId().equals(guest.getGuestId())) {
                throw new InvalidGuestException("Duplicate guest entry.");
            }
        }
        guests.add(guest);
    }

    public List<Guest> getGuests() {
        return guests;
    }
}

class InvalidGuestException extends Exception {
    public InvalidGuestException(String message) {
        super(message);
    }
}
