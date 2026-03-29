package Week_3_Assignment1_Solutions.Problem5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {

        // Fixed pool of 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submitting multiple tasks
        for (int i = 1; i <= 8; i++) {
            executor.execute(new Task("Task-" + i));
        }

        // Graceful shutdown
        executor.shutdown();
    }
}

