package Mini_Library_Management_System;
import java.io.*;
import java.util.*;
// this is central class where I'll manage books & member
// basically this is service class
public class LibraryService implements Serializable {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    // we will have multiple books and multiple members
    // that's why i have created an arraylist of book and member in which
    // I'll store book objects and member objects

    // ========================================== BOOK OPERATIONS ==================
    // this will be done by admin
    public void addBook(Book book) {
        books.add(book);
        // I am storing book in books arraylist
    }

    public void removeBook(int id) throws BookNotFoundException {
        boolean removed = books.removeIf(b -> b.getId() == id);
        //removeIf() is a default method introduced in Java 8 in the Collection interface
        // and it removes elements based on a given predicate.
        //removeIf() ->does the iteration
        //b -> b.getId() == id  - > logic applied to each element
        // removeif returns true if element is removed from arraylist
        if (!removed) {
            // if element wasn't removed
            // means book was not present
            // hence i'm throwing an exception
            throw new BookNotFoundException("Book ID " + id + " not found");
        }
    }

    public List<Book> getBooksSortedByTitle() {
        // while using comparator i know we create separate class and extends
        // Comparator interface
        // but to show usecase of anonymous classes i haven't created separate class
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book b : books) {
            if (b.isAvailable()) {
                available.add(b);
            }
        }
        return available;
    }

    public Book findBook(int id) throws BookNotFoundException {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;

                //if i find book then i will return that book object
            }
        }
        // and if not then below statement will be excuted and
        // expection called BookNotFoundException will be thrown
        throw new BookNotFoundException("Book ID " + id + " not found");
    }

    // ============================= MEMBER OPERATIONS =================

    public void addMember(Member member) {
        members.add(member);
        // adding member object in members arraylist
    }

    public List<Member> getMembers() {
        return members;
        // getting members arraylist
    }

    // ================= FILE HANDLING =================

    // Save all records (books + members) to file
    public void saveToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.ser"))) {
            oos.writeObject(this);
            // actually i storing whole library object
        }
    }

    // Load records from file
    public static LibraryService loadFromFile()throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.ser"))) {
            return (LibraryService) ois.readObject();
        }
    }
}
