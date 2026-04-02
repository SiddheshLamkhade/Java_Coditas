package Week2Assigment1.Problem8;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) {

        try {
            // Creating  object
            User u1 = new User("siddhesh", "secret123", "sid@gmail.com");
            // Object created in memory

            // Serialization
            // creating file to store bytes into it
            FileOutputStream fos = new FileOutputStream("user.ser");
            //creating an object output stream that can write Java objects to a file.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //storing in a file.
            oos.writeObject(u1);
            oos.close();

            // Deserialization
            FileInputStream fis = new FileInputStream("user.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User u2 = (User) ois.readObject();
            ois.close();

            // Print values
            System.out.println("Username : " + u2.username);
            System.out.println("Password : " + u2.password);
            System.out.println("Email    : " + u2.email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
