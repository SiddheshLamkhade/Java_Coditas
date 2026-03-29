package Week_3_Assignment1_Solutions.Problem8;

import java.util.concurrent.Semaphore;

class Tunnel {
    private final Semaphore semaphore = new Semaphore(3); // 3 cars allowed

    void passThrough(String carName) {
        try {
            System.out.println(carName + " waiting to enter tunnel");

            semaphore.acquire();   // acquire permit
            System.out.println(carName + " entered tunnel");

            Thread.sleep(2000);    // simulating passing through tunnel

            System.out.println(carName + " exited tunnel");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();  // releasing permit
        }
    }
}

