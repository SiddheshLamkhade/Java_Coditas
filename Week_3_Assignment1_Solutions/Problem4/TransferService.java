package Week_3_Assignment1_Solutions.Problem4;

class TransferService {

    static void transfer(Account from, Account to, int amount) {

        Account firstLock;
        Account secondLock;

        // I am applying Lock ordering based on account ID
        if (from.getId() < to.getId()) {
            firstLock = from;
            secondLock = to;
        } else {
            firstLock = to;
            secondLock = from;
        }

        synchronized (firstLock) {
            synchronized (secondLock) {

                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);

                    System.out.println(
                        Thread.currentThread().getName() +
                        " transferred " + amount
                    );
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        }
    }
}

