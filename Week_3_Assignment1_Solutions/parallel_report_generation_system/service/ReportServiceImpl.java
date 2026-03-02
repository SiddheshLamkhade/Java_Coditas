package Week_3_Assignment1_Solutions.parallel_report_generation_system.service;



import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import Week_3_Assignment1_Solutions.parallel_report_generation_system.model.LogUtil;
import Week_3_Assignment1_Solutions.parallel_report_generation_system.model.Report;
import Week_3_Assignment1_Solutions.parallel_report_generation_system.model.ReportTask;

public class ReportServiceImpl implements ReportService {

    private ExecutorService executorService;

    public ReportServiceImpl() {
    }

    public ReportServiceImpl(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void generateReports() {

        int totalReports = 8;
        CountDownLatch latch = new CountDownLatch(totalReports);

        LogUtil.log("Main thread waiting for all reports...");

        for (int i = 1; i <= totalReports; i++) {
            Report report = new Report("Report-" + i);
            executorService.submit(new ReportTask(report, latch));
        }

        try {
            latch.await();
            LogUtil.log("All reports generated. Dashboard is ready.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }
}
