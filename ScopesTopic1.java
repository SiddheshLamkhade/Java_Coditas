import java.util.*;
public class ScopesTopic1 {


    private int a;
     //Instance variable   inside a class but outside methods
    // Default values are provided (0, null, false)

    static int b;
    //Class Variables-Static Variables
    // Default values are provided (0, null, false)

    public static void main() {
        Scanner sc= new Scanner(System.in);
        int c=23;
        //local variable Must be initialized before use
        System.out.println(b);
    }
}
