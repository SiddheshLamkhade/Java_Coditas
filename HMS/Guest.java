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


