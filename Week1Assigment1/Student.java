package Week1Assigment1;
//pojo class
public class Student {

    private int id;
    private String firstname;
    private String lastname;

    private Course[] courses = new Course[4];
    //I am using course array to store  course id with the help of below variable

    private int courseCount = 0;
    // This courseCount will be different for different students
    // And it will be decided it with the help of enum

    public Student(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public boolean addCourse(Course course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i] == course) {   // logical equality for enum
                return false;
            }
        }
        courses[courseCount++] = course;
        return true;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append("  First Name: ").append(firstname)
                .append("  Last Name: ").append(lastname)
                .append("  Courses: ");

        for (int i = 0; i < courseCount; i++) {
            sb.append(courses[i]).append(" ");
        }
        return sb.toString();
    }
}
