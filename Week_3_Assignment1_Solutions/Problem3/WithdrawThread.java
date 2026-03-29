package Week_3_Assignment1_Solutions.Problem3;

class WithdrawThread extends Thread {
    BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(100);
            System.out.println("Withdrawn 100 | Balance: " + account.getBalance());
        }
    }
}