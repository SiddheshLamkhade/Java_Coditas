package Mini_Library_Management_System;
// I have kept file name different because none of the classes in this file is public

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}
