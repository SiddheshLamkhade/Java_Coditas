package Week_3_Assignment1_Solutions.Problem4;

public class DeadlockFreeBankDemo {
    public static void main(String[] args) {

        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);

        Thread t1 = new TransferThread(acc1, acc2, 100);
        Thread t2 = new TransferThread(acc2, acc1, 200);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}

