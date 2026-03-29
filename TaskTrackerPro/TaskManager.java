package TaskTrackerPro;

import java.io.*;

import java.util.*;

class TaskManager implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, User> users = new HashMap<>();

    public synchronized void addUser(String username) {
        users.putIfAbsent(username, new User(username));
    }

    public synchronized User getUser(String username) {
        return users.get(username);
    }

    public synchronized Collection<User> getAllUsers() {
        return users.values();
    }

    public synchronized void saveToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("tasktracker.dat"))) {
            oos.writeObject(this);
            System.out.println("AutoSave- Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public static TaskManager loadFromFile() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("tasktracker.dat"))) {
            return (TaskManager) ois.readObject();
        } catch (Exception e) {
            return new TaskManager();
        }
    }
}
