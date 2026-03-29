package Week_3_Assignment1_Solutions.Problem4;

class TransferThread extends Thread {
    private final Account from;
    private final Account to;
    private final int amount;

    TransferThread(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        TransferService.transfer(from, to, amount);
    }
}

