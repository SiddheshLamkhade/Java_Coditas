package Week2Assigment1.Problem3;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Press 1 for Full Time Employee");
        System.out.println("Press 2 for Part Time Employee");

        int choice = input.nextInt();
        Employee emp;

        if (choice == 1) {
            emp = new FullTimeEmployee();   // runtime decision
        } else if (choice == 2) {
            emp = new PartTimeEmployee();   // runtime decision
        } else {
            System.out.println("Invalid input");
            return;
        }

        System.out.print("Enter id: ");
        emp.id = input.nextInt();

        System.out.print("Enter name: ");
        emp.name = input.next();

        System.out.print("Enter surname: ");
        emp.surname = input.next();

        emp.calculateSalary();   // runtime polymorphism
        emp.displayDetails();

        input.close();
    }
}
