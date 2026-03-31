package Mini_Library_Management_System;
import java.io.*;

public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private boolean available = true; // to check whether book is available in library or not


    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    // while creating an object i will pass book's id, title and author
    // initially available field will be set to true


    // gettters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return available;
    }

    // to change the status of availability I will use following methods
    // if i want to issue current book object to someone i will call this method
    public void issue() {
        this.available = false;
    }
    // if i want to receive current book object from library member and to keep in library
    // i will call this method
    public void giveBack() {
        this.available = true;
    }


    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (available ? "Available" : "Issued");
    }
    // when i will print object of book it will trigger to string method
    // and here i have overridden to string method to print in my desired output
}
