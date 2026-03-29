package Week_3_Assignment1_Solutions.parallel_report_generation_system.model;



import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class ReportTask implements Runnable {

    private Report report;
    private CountDownLatch latch;

    public ReportTask() {
    }

    public ReportTask(Report report, CountDownLatch latch) {
        this.report = report;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            LogUtil.log(report.getReportId() + " started.");

            int delay = ThreadLocalRandom.current().nextInt(2, 5);
            Thread.sleep(delay * 1000L);

            LogUtil.log(report.getReportId() + " completed.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}
