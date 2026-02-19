package Week_3_Assignment1_Solutions.Problem6;

import java.util.concurrent.CountDownLatch;

public class RelayRaceDemo_CountDownLatch{
    public static void main(String[] args) {

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        Thread runner1 = new Runner("Runner 1", null, latch1);
        Thread runner2 = new Runner("Runner 2", latch1, latch2);
        Thread runner3 = new Runner("Runner 3", latch2, null);

        runner1.start();
        runner2.start();
        runner3.start();
    }
}

