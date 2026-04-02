package salary_calculation_module.model;

abstract public class Employee {

    protected String name;
    protected double baseSalary;
    protected int attendanceDays;
    protected int performanceRating;
    public static final double PF_PERCENT = 0.12;

    public Employee(String name, double baseSalary, int attendanceDays, int performanceRating) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.attendanceDays = attendanceDays;
        this.performanceRating = performanceRating;
    }

   
    abstract double calculateGrossSalary(); // Role based gross salary. this will be overriden

   
    double calculateAttendanceDeduction() { //Attendance deduction. this is common for all
        double dailySalary = baseSalary / 30;
        int absentDays = 30 - attendanceDays;
        return absentDays * dailySalary;
    }

    double calculateBonus(double grossSalary) {  // Performance bonus
        double bonusPercent = switch (performanceRating) {
            case 5 -> 0.20;
            case 4 -> 0.15;
            case 3 -> 0.10;
            case 2 -> 0.05;
            default -> 0.0;
        };
        return grossSalary * bonusPercent;
    }

  
    double calculatePF() {  // PF deduction
        return baseSalary * PF_PERCENT;
    }

  
    double calculateTax(double taxableIncome) {  //  Tax calculation
        double taxRate;
        if (taxableIncome <= 50000) taxRate = 0.05;
        else if (taxableIncome <= 100000) taxRate = 0.10;
        else if (taxableIncome <= 150000) taxRate = 0.15;
        else taxRate = 0.20;

        return taxableIncome * taxRate;
    }

    
    public void generateSalarySlip() {// Net salary calculation

        double grossSalary = calculateGrossSalary();
        double attendanceDeduction = calculateAttendanceDeduction();
        double bonus = calculateBonus(grossSalary);
        double pf = calculatePF();
        double tax = calculateTax(grossSalary + bonus);

        double netSalary = grossSalary + bonus - tax - pf - attendanceDeduction;

        System.out.println("\n============= Salary Slip ==================");
        System.out.println("Employee Name: " + name);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("PF Deduction: " + pf);
        System.out.println("Tax: " + tax);
        System.out.println("Attendance Deduction: " + attendanceDeduction);
        System.out.println("Net Salary: " + netSalary);        
        
    }
}

