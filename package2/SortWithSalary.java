package package2;

import java.util.Comparator;

public class SortWithSalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.salary,o2.salary);
    }
}
