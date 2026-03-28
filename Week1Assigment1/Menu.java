package Week1Assigment1;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Course Enrollment System.");

        int choice;
        StudentService ss = new StudentService();

        do {
            System.out.println("\nKindly press following options");
            System.out.println("Press 1: To add Enrollment");
            System.out.println("Press 2: To display student details");
            System.out.println("Press 3: To save the data to a file");
            System.out.println("Press 0: To exit from this system");
            System.out.print("Enter your option : ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    ss.addStudent();
                    break;

                case 2:
                    ss.display();
                    break;

                case 3:
                    ss.saveinfile();
                    break;

                case 0:
                    System.out.println("Thank You..... Exiting from the system....");
                    break;

                default:
                    System.out.println("Kindly enter a valid option");
            }

        } while (choice != 0);

        input.close();
    }
}
