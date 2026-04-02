package Week2Assigment1.Problem4;

import java.util.Scanner;

public class BankAccount {

    private int balance = 0;   // private member

    // Inner class
    class Transaction {

        void deposit(int amount) {
            balance = balance + amount;   // accessing private variable
            System.out.println("Deposited: " + amount);
            System.out.println("Balance: " + balance);
        }

        void withdraw(int amount) {
            if (amount <= balance) {
                balance = balance - amount;   // accessing private variable
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance");
            }
            System.out.println("Balance: " + balance);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        BankAccount.Transaction tx = new BankAccount().new Transaction();


        System.out.println("To deposit press 1");
        System.out.println("To withdraw press 2");
        int ch = input.nextInt();

        if (ch == 1) {
            System.out.print("Enter amount to be deposited: ");
            int d = input.nextInt();
            tx.deposit(d);
        }
        else if (ch == 2) {
            System.out.print("Enter amount to be withdrawn: ");
            int w = input.nextInt();
            tx.withdraw(w);
        }
        else {
            System.out.println("Invalid input");
        }

        input.close();
    }
}
