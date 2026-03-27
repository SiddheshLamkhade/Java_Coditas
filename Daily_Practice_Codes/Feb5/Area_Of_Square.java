package Daily_Practice_Codes.Feb5;
import java.util.*;
/**
 * This code is from Week1 Assignment provided to the Java Batch students.
 * This is Question no. 1 : In a program, input the side of a square. You have to output the area of the square
 */
public class Area_Of_Square {
    public static void main() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the side of square in metres : ");
        int side=sc.nextInt();
        System.out.print("Area is : " + (side*side));
    }
}
