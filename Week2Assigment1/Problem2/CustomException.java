package Week2Assigment1.Problem2;

import java.sql.SQLOutput;

// Custom runtime exception
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
        // I have made a constructor and passed the message that was received for this exception...
        // ...to the parent class RuntimeException
    }
}

// User class
class User {
    String name;
    int age;

    User(String name, int age) {
        if (age < 18) {
            System.out.println("Current age is : "+ age);
            throw new InvalidAgeException("Age must be at least 18!");

        }
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }
}

// Main class
public class CustomException {
    public static void main(String[] args) {
        try {
            User u = new User("Alice", 25);  // age < 18 triggers exception
            u.display();
            User objUser = new User("Alice", 15);
            objUser.display();
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // This user is valid
        User u2 = new User("Bob", 20);
        u2.display();
    }
}
