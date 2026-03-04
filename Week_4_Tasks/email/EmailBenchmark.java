package Week_4_Tasks.email;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EmailBenchmark {

    private static final int USER_COUNT = 10_000;

    public static void main(String[] args) throws InterruptedException {

        EmailSender sender = new EmailSender();

        // Platform Threads
        try (ExecutorService executor =
                     Executors.newFixedThreadPool(100)) {

            Instant start = Instant.now();

            IntStream.range(0, USER_COUNT)
                    .forEach(i ->
                            executor.submit(() ->
                                    sender.sendEmail("user" + i + "@mail.com")));

            executor.shutdown();
            while (!executor.isTerminated()) { }

            Instant end = Instant.now();
            System.out.println("Platform Threads Time: " +
                    Duration.between(start, end));
        }

        // Virtual Threads
        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            Instant start = Instant.now();

            IntStream.range(0, USER_COUNT)
                    .forEach(i ->
                            executor.submit(() ->
                                    sender.sendEmail("user" + i + "@mail.com")));

            executor.shutdown();
            while (!executor.isTerminated()) { }

            Instant end = Instant.now();
            System.out.println("Virtual Threads Time: " +
                    Duration.between(start, end));
        }
    }
}
