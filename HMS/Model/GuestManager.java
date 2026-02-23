package HMS.Model;

import java.util.*;

public class GuestManager {
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


