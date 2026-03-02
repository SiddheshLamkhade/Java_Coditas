package Week_3_Assignment1_Solutions.PracticeWithSagar;
import java.util.*;

public class SwitchCase {
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);

        // switch case old syntax
        int v=2;
        switch(v){
            case 0:
                System.out.println("Monday");
                break;
            case 1: 
                System.out.println("Tuesday");
                break;
            default: 
                System.out.println("not in the option");
        }

        //switch case new syntax
        String s="Monday";
        int value=switch(s){
            case "Monday" ->1;
            case "Tuesday"->2;
            default->0;
        };

        // var keyword
        var al= new ArrayList<>();
        al.add(323);
        al.add("sid");
        al.add(new Object());

        String data="""
                Siddhesh=99 %
                Atharva=98%
                       jiii
                       Ramm 
                                 ji 
                       ki    
                """;
        System.out.println(data);

    }

}
