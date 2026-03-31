package Mini_Library_Management_System;

import java.io.*;
public class Member implements Serializable {
    private int memberId;
    private String name;// name of library member who will be using library books
    private Book issuedBook;  //this variable will tell which book has been issued to the associated member

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    //getters
    public int getMemberId() { return memberId; }
    public Book getIssuedBook() { return issuedBook; }

    // When i want to set issuedbook to the member
    // I'll call this method
    public void issueBook(Book book) {
        this.issuedBook = book;
    }

    // When i want to remove associated book from that member
    // i will set issuedBook variable to null
    public void returnBook() {
        this.issuedBook = null;
    }

    // when object is printed , it calls toString
    // so i am overriding my member class's object for desired format
    @Override
    public String toString() {
        return memberId + " | " + name + " | Issued: " +
                (issuedBook == null ? "None" : issuedBook.getTitle());
    }
}
