package Week_3_Assignment1_Solutions.Problem6;

import java.util.concurrent.CountDownLatch;

class Runner extends Thread {
    private final String name;
    private final CountDownLatch waitLatch;
    private final CountDownLatch nextLatch;

    Runner(String name, CountDownLatch waitLatch, CountDownLatch nextLatch) {
        this.name = name;
        this.waitLatch = waitLatch;
        this.nextLatch = nextLatch;
    }

    @Override
    public void run() {
        try {
            if (waitLatch != null) {
                waitLatch.await();   // wait for previous runner
            }

            System.out.println(name + " started running");
            Thread.sleep(2000);     // simulate running
            System.out.println(name + " finished running");

            if (nextLatch != null) {
                nextLatch.countDown(); // signal next runner
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

