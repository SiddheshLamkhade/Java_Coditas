package Week2Assigment1.Problem1;
import java.util.*;

public class ExceptionHandling {
    static void main() {
        Scanner input=new Scanner(System.in);
        // If any exception occurs while taking any input it will throw an exception and will be handled in catch method
            try {
                System.out.print("Enter first number : ");
                int num1=input.nextInt();
                System.out.print("Enter second number : ");
                int num2= input.nextInt();
                int c= num1/num2;
                System.out.println("Result is : "+c);
            }
            // if exception occurs due to no. divided by 0 then it will be caught by this catch block
            catch (ArithmeticException e){
                System.out.println("ArithmeticException has been occured");
            }
            // if exception occurs due input e.g. passing a string instead of a number then it will be caught by this catch block
            catch (InputMismatchException ie){
                System.out.println("InputMismatchException has been occured");
            }

            finally {
                System.out.println("Program execution completed");
            }

    }

}
