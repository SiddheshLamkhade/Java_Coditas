package Daily_Practice_Codes.Feb4;
import java.util.*;

/**
 * This code is from Week1 Assignment provided to the Java Batch students
 * This is Question no. 2 : In a program, input 3 numbers : compute the average of three numbers
 */
public class Average {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first no : ");
        int num1= sc.nextInt();
        System.out.print("Enter second no : ");
        int num2= sc.nextInt();
        System.out.print("Enter third no : ");
        int num3= sc.nextInt();
        int res=(num1+num2+num3)/3;
        System.out.print("Average of three numbers is : "+ (res));
    }
}
