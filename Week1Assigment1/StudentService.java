package Week1Assigment1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentService {

    private Student[] students = new Student[10];
    private int count = 0;
    private int idCounter = 1;

    private Scanner sc = new Scanner(System.in);


    // here i have written code to add the students
    public void addStudent() {
        if (count >= students.length) {
            System.out.println("Student limit reached");
            return;
        }

        System.out.print("Enter first name: ");
        String fname = sc.nextLine();

        System.out.print("Enter last name: ");
        String lname = sc.nextLine();

        Student student = new Student(idCounter++, fname, lname);

        while (true) {
            System.out.print("Enter course (or 'done'): ");
            String input = sc.nextLine();

            //
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                Course course = Course.valueOf(input.toUpperCase());
                if (!student.addCourse(course)) {
                    System.out.println("Course already enrolled!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid course!");
            }
        }

        students[count++] = student;
    }


    // here i am displaying the info of students with the help of array
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    public void saveinfile() throws IOException {
        FileWriter fw = new FileWriter("file.txt");
        for (int i = 0; i < count; i++) {
            fw.write(students[i].toString() + "\n");
        }
        fw.close();
        System.out.println("Data saved successfully.");
    }
}
