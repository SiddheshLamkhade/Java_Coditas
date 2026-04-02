package salary_calculation_module.app;

import salary_calculation_module.model.*;

public class Main {

    public static void main(String[] args) {

        Employee dev = new Developer("Siddhesh", 80000, 26, 5, 10);
        Employee mgr = new Manager("Tanmay", 120000, 28, 4, 8);
        Employee intern = new Intern("Snehal", 30000, 18, 3);

        dev.generateSalarySlip();
        mgr.generateSalarySlip();
        intern.generateSalarySlip();
    }
}

