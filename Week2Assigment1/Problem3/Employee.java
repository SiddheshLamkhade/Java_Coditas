package Week2Assigment1.Problem3;

public abstract class Employee {

    int id;
    String name;
    String surname;
    int salary;

    abstract int calculateSalary();

    void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Salary: " + salary);
    }
}
