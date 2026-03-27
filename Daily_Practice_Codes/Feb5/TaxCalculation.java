package Daily_Practice_Codes.Feb5;
import java.util.*;
/**
 * This code is from Week1 Assignment provided to the Java Batch students.
 * This is Question no. 5 :Accept salary from user along with choice to calculate tax using Old Tax Regime or New Tax Regime and calculate the tax for the given salary.
 * New tax regime slabs:
 *
 * 0 to 250000=Nil
 * 250000 to 500000=5%
 * 500000 to 750000=10%
 * 750000 to 1000000=15%
 * 1000000 to 1250000=20%
 * 1250000 to 1500000=25%
 * Greater than 1500000=30%
 *
 * Old tax regime slabs:
 * 0 to 250000=Nil
 * 250000 to 500000=5%
 *500000 to 1000000=20%
 * Greater than 1000000=30%
 */
public class TaxCalculation {
    public static void main(String[] args) {
        System.out.print("Enter the salary : ");
        Scanner sc=new Scanner(System.in);
        int salary=sc.nextInt();
        System.out.println("Select the option to calculate the tax with : ");
        System.out.println( "Press 1 : Old Tax Regime");
        System.out.println("Press 2 : New Tax Regime");
        int choice =sc.nextInt();
        if(choice==1){
            System.out.print("Your tax with Old Tax Regime will be : " + calculateTax_OldTaxRegime(salary));
        }
        else{
            System.out.print("Your tax with New Tax Regime will be : " + calculateTax_NewTaxRegime(salary));
        }
    }
    static int calculateTax_OldTaxRegime(int sal){
        int salary=sal;
        int tax=0;


        return 0;
    }
    static int calculateTax_NewTaxRegime(int sal){
        return 0;
    }
}
