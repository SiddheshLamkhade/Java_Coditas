package Week_3_Assignment1_Solutions.parallel_report_generation_system.configuration;

import java.util.concurrent.*;

public class ExecutorConfig {

    public ExecutorConfig() {
    }

    public ExecutorService reportExecutor() {
        return Executors.newFixedThreadPool(2);
    }
}