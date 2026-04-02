package Week2Assigment1.Problem9;
import java.util.*;
public class MapOrdering {
    public static void main(String[] args) {

        // HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(11, "Ravi");
        hashMap.put(22, "Amit");
        hashMap.put(33, "Suresh");
        hashMap.put(44, "Neha");
        hashMap.put(55, "Anita");

        System.out.println("HashMap Output:");
        hashMap.forEach((k, v) -> System.out.println(k + " : " + v));

        // LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Ravi");
        linkedHashMap.put(2, "Amit");
        linkedHashMap.put(3, "Suresh");
        linkedHashMap.put(4, "Neha");
        linkedHashMap.put(5, "Anita");

        System.out.println("\nLinkedHashMap Output:");
        linkedHashMap.forEach((k, v) -> System.out.println(k + " : " + v));

        // TreeMap
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "Ravi");
        treeMap.put(2, "Amit");
        treeMap.put(3, "Suresh");
        treeMap.put(4, "Neha");
        treeMap.put(1, "Anita");

        System.out.println("\nTreeMap Output:");
        treeMap.forEach((k, v) -> System.out.println(k + " : " + v));

        List<HashMap<Integer,Integer>> lmap=new ArrayList<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(2,3);
        mp.put(4,3);
        lmap.add(mp);
        HashMap<Integer,Integer> mp1=new HashMap<>();
        mp1.put(12,3);
        mp1.put(14,3);
        lmap.add(mp1);

    }
}
