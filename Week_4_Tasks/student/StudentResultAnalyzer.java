package Week_4_Tasks.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentResultAnalyzer {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(List.of(
                new Student("Aman", 85),
                new Student("Riya", 92),
                new Student("Karan", 70),
                new Student("Neha", 95)
        ));

        // Topper
        students.stream()
                .max(Comparator.comparingInt(Student::marks))
                .ifPresent(topper ->
                        System.out.println("Topper: " + topper));

        // Lowest
        students.stream()
                .min(Comparator.comparingInt(Student::marks))
                .ifPresent(lowest ->
                        System.out.println("Lowest: " + lowest));

        // SequencedCollection (Java 21)
        System.out.println("First Student: " + students.getFirst());
        System.out.println("Last Student: " + students.getLast());

        List<Student> reversed = students.reversed();
        System.out.println("Reversed List: " + reversed);
    }
}
