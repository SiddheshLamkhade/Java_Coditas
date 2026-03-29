package Week_3_Assignment1_Solutions.Problem3;

class DepositThread extends Thread {
    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            System.out.println("Deposited 100 | Balance: " + account.getBalance());
        }
    }
}



