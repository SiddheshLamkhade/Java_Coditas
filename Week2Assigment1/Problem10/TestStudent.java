package Week2Assigment1.Problem10;

import java.util.ArrayList;
import java.util.Collections;

public class TestStudent {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(1, "Ravi", 85));
        list.add(new Student(2, "Amit", 92));
        list.add(new Student(3, "Neha", 78));
        list.add(new Student(4, "Sita", 88));

        // Sort by marks (Comparable)
        Collections.sort(list);
        System.out.println("Sorted by Marks:");
        for (Student s : list) {
            s.display();
        }

        // Sort by name (Comparator)
        Collections.sort(list, new NameComparator());
        System.out.println("\nSorted by Name:");
        for (Student s : list) {
            s.display();
        }
    }
}
