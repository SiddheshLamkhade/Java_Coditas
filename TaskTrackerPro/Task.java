package TaskTrackerPro;

import java.io.*;

import java.util.concurrent.atomic.AtomicInteger;


class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    // It ensures InvalidClassException when the class structure changes

    private static AtomicInteger idGenerator = new AtomicInteger(1);
            // it is thread safe integer for synchronization
    private int id;
    private String title;
    private String status;
    private int priority;

    public Task(String title, int priority) {
        this.id = idGenerator.getAndIncrement();
        this.title = title;
        this.priority = priority;
        this.status = "PENDING";
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public int getPriority() { return priority; }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
                ", Title: " + title +
                ", Priority: " + priority +
                ", Status: " + status;
    }
}
