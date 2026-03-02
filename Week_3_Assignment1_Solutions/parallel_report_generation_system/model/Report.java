package Week_3_Assignment1_Solutions.parallel_report_generation_system.model;

public class Report {

    private String reportId;

    public Report() {
        // Default constructor
    }

    public Report(String reportId) {
        this.reportId = reportId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
}
