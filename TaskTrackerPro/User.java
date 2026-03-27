package TaskTrackerPro;

import java.io.Serializable;
import java.util.*;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private List<Task> tasks = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() { 
        return username; 
    }
    public List<Task> getTasks() {
         return tasks; 
    }
}
