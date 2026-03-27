package TaskTrackerPro;

import java.util.*;

public class TaskTrackerPro {

    private static Scanner sc = new Scanner(System.in);
    private static TaskManager manager;

    public static void main(String[] args) {

        manager = TaskManager.loadFromFile();
        new AutoSaveThread(manager).start();

        while (true) {
            System.out.println("\n================== TaskTracker Pro =================");
            System.out.println("1. Create User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createUser();
                case 2 -> login();
                case 3 -> {
                    manager.saveToFile();
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        manager.addUser(username);
        System.out.println("User created successfully.");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        User user = manager.getUser(username);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        while (true) {
            System.out.println("\n-------- Task Menu -----------------------");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. View Tasks by Priority");
            System.out.println("4. Update Task Status");
            System.out.println("5. Delete Task");
            System.out.println("6. Search Task by Title");
            System.out.println("7. Logout");
            System.out.print("Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            synchronized (user) {
                switch (ch) {
                    case 1 -> addTask(user);
                    case 2 -> viewTasks(user);
                    case 3 -> viewSortedTasks(user);
                    case 4 -> updateStatus(user);
                    case 5 -> deleteTask(user);
                    case 6 -> searchTask(user);
                    case 7 -> { return; }
                    default -> System.out.println("Invalid choice");
                }
            }
        }
    }

    private static void addTask(User user) {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Priority (1-High, 5-Low): ");
        int p = sc.nextInt();
        sc.nextLine();
        user.getTasks().add(new Task(title, p));
    }

    private static void viewTasks(User user) {
        user.getTasks().forEach(System.out::println);
    }

    private static void viewSortedTasks(User user) {
        user.getTasks().stream()
                .sorted(Comparator.comparingInt(Task::getPriority))
                .forEach(System.out::println);
    }

    private static void updateStatus(User user) {
        System.out.print("Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Task t : user.getTasks()) {
            if (t.getId() == id) {
                t.setStatus("COMPLETED");
                return;
            }
        }
        System.out.println("Task not found");
    }

    private static void deleteTask(User user) {
        System.out.print("Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        user.getTasks().removeIf(t -> t.getId() == id);
    }

    private static void searchTask(User user) {
        System.out.print("Keyword: ");
        String key = sc.nextLine();
        user.getTasks().stream()
                .filter(t -> t.getTitle().toLowerCase().contains(key.toLowerCase()))
                .forEach(System.out::println);
    }
}