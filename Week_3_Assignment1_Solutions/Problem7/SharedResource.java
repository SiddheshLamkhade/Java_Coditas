package Week_3_Assignment1_Solutions.Problem7;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {

    private int value = 0;
    private final ReentrantLock lock = new ReentrantLock(true); // fair lock

    void increment() {
        lock.lock();   // acquire lock
        try {
            System.out.println(Thread.currentThread().getName() +
                    " acquired lock");

            value++;
            Thread.sleep(1000); // simulate work

            System.out.println(Thread.currentThread().getName() +
                    " updated value to " + value);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();  // MUST release lock
            System.out.println(Thread.currentThread().getName() +
                    " released lock");
        }
    }
}

