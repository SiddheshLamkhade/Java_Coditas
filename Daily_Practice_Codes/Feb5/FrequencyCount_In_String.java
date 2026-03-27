package Daily_Practice_Codes.Feb5;
import java.util.*;
/**
 * This code is from Week1 Assignment provided to the Java Batch students.
 * This is Question no. 4 : Compress a string in the below format
 *                          Input: -> "aaabbcccdd"	Output: -> "a3b2c3d2"
 */
public class FrequencyCount_In_String {
        public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           String str=sc.next();
           StringBuilder sb= new StringBuilder();
           LinkedHashMap<Character,Integer> map= new LinkedHashMap<>();
           for (int i=0; i<str.length(); i++){
                   char ch=str.charAt(i);
                   map.put(ch,map.getOrDefault(ch,0)+1);
           }
           for(Character ch: map.keySet()){
                   sb.append(ch);
                   sb.append(map.get(ch));
           }
           System.out.println(sb.toString());
        }

}
