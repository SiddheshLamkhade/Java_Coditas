package Week_3_Assignment1_Solutions.Problem4;

class Account {
    private int balance;
    private final int id;   // unique id for lock ordering

    Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    int getId() {
        return id;
    }

    int getBalance() {
        return balance;
    }

    void withdraw(int amount) {
        balance -= amount;
    }

    void deposit(int amount) {
        balance += amount;
    }
}
//in this program Each account object itself will act as a lock
