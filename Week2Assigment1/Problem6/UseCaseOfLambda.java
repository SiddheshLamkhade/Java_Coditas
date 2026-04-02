package Week2Assigment1.Problem6;
import  java.util.*;
public class


UseCaseOfLambda {
    public static void main() {
        List<String> employees = new ArrayList<>();
        // We have been asked to create list of String that's why I haven't created list of employee objects
        employees .add("Siddhesh");
        employees .add("Ram");
        employees .add("Sita");
        employees .add("Snehal");

        System.out.println("\nAll Names : ");
        // printing names using lambda function as asked
        employees.forEach(e -> System.out.println(e));

        System.out.println("\nNames starting with 'S':");
        // Filtering names starting with 'S'
        employees.stream()
                .filter(e -> e.startsWith("S"))
                .forEach(name -> System.out.println(name));

        System.out.println("\nNames in alphabetical order:");
        // Sorting names alphabetically
        employees.stream()
                .sorted()
                .forEach(name -> System.out.println(name));
    }
}
