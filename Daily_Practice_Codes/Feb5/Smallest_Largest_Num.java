package Daily_Practice_Codes.Feb5;
import java.util.*;
/**
 * This code is from Week1 Assignment provided to the Java Batch students.
 * This is Question no. 3 :Find largest and small number in an array
 */
public class Smallest_Largest_Num {
    public static void main(String[] args) {
        int[] arr= {322,454,23,5235,2,4,6,1,2342,34};
        int maxele=-1;
        int minele=Integer.MAX_VALUE;
        for (int ele: arr){
            if(ele>maxele){
                maxele=ele;
            }
            if(ele<minele){
                minele=ele;
            }
        }
        System.out.println("Largest ele in an array is : "+ maxele);
        System.out.println("Smallest ele in an array is : "+ minele);
    }
}
