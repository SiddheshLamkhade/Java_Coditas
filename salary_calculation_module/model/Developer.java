package salary_calculation_module.model;

public class Developer extends Employee {

    private int overtimeHours;

    public Developer(String name, double baseSalary, int attendanceDays, int performanceRating, int overtimeHours) {
        super(name, baseSalary, attendanceDays, performanceRating);
        this.overtimeHours = overtimeHours;
    }

    @Override
    double calculateGrossSalary() {
        return baseSalary + (overtimeHours * 500);
    }
}
