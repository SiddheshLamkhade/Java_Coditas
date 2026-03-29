package Week_3_Assignment1_Solutions.parallel_report_generation_system;

import Week_3_Assignment1_Solutions.parallel_report_generation_system.configuration.ExecutorConfig;
import Week_3_Assignment1_Solutions.parallel_report_generation_system.service.ReportService;
import Week_3_Assignment1_Solutions.parallel_report_generation_system.service.ReportServiceImpl;

public class ReportApplication {

    public ReportApplication() {
    }

    public static void main(String[] args) {

        ExecutorConfig config = new ExecutorConfig();
        ReportService service =
                new ReportServiceImpl(config.reportExecutor());

        service.generateReports();
    }
}
