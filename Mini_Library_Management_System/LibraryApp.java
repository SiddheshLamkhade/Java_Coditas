package Mini_Library_Management_System;

import java.util.*;

public class LibraryApp {

    static Scanner input = new Scanner(System.in);
    static LibraryService libraryService = new LibraryService();
    // we have been asked to create admin operations and member operations
    // so we will have to create separate menu for them
    // and that will be static so to access input and library object inside them
    // I have kept them static

    public static void main(String[] args) {

        libraryService.addMember(new Member(1, "Siddhesh"));

        while (true) {
            System.out.println("1.Admin 2.Member 3.Exit");
            System.out.print("Enter your choice : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> adminMenu();
                // calling adminmenu function
                case 2 -> memberMenu();
                // calling memberMenu function
                case 3 -> System.exit(0);
                //System.exit(0) method initiates the shutdown of jvm
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // ================= ADMIN MENU =================
    static void adminMenu() {

        System.out.println("1.Add book 2.Remove Book 3.View books 4.View Members 5.Save 6.Load");
        int ch = input.nextInt();

        try {
            switch (ch) {
                case 1 -> {
                    System.out.print("Id Title Author: ");
                    libraryService.addBook(
                            new Book(input.nextInt(), input.next(), input.next()));
                }
                case 2 -> {
                    System.out.print("Enter Book ID: ");
                    libraryService.removeBook(input.nextInt());
                    //Java evaluates method arguments first that's why
                    // program waits for user to type a number
                    // this method throws exception
                }
                case 3 -> libraryService.getBooksSortedByTitle()
                        .forEach(book -> System.out.println(book));
                // as a return type of getBooksSortedByTitle is list so once it returns list
                // i am using foreach loop on that list
                case 4 -> libraryService.getMembers()
                        .forEach(m -> System.out.println(m));
                case 5 -> libraryService.saveToFile();

                case 6-> {
                    LibraryService lib = LibraryService.loadFromFile();
                    lib.getBooksSortedByTitle().forEach(b -> System.out.println(b));
                }
                default -> System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================= MEMBER MENU =================
    static void memberMenu() {

        Member member = libraryService.getMembers().get(0);

        System.out.println("1.View Books 2.Issue 3.Return 4.My Book");
        int ch = input.nextInt();

        try {
            switch (ch) {
                case 1 -> libraryService.getAvailableBooks()
                        .forEach(book -> System.out.println(book));

                case 2 -> {
                    System.out.print("Enter Book ID: ");
                    int id = input.nextInt();
                    Book book = libraryService.findBook(id);
                    // this method also throws an exception
                    if (!book.isAvailable()) {
                        throw new BookNotAvailableException("Book already issued");
                    }

                    book.issue();
                    member.issueBook(book);
                }

                case 3 -> {
                    if (member.getIssuedBook() != null) {
                        member.getIssuedBook().giveBack();
                        member.returnBook();
                    } else {
                        System.out.println("No book to return");
                    }
                }

                case 4 -> System.out.println(member.getIssuedBook());

                default -> System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
