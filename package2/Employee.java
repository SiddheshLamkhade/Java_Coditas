package package2;


import java.util.*;
public class Employee implements Comparable<Employee>{
    public int id;
    public float salary;
    Employee(int id, int salary){
        this.id=id;
        this.salary=salary;
    }
    @Override
    public int compareTo(Employee o) {
        return this.id-o.id;
    }
}
class Main{
    static void main() {

        //Employee em2=new Employee();
        List<Employee> ls=new ArrayList<>();
        ls.add(new Employee(3,500000));
        ls.add(new Employee(2,490000));

        ls.add(new Employee(4,510000));
        ls.stream().sorted().forEachOrdered(e-> {if(e.salary>=500000) {
            System.out.println(e.id);
        }
        });
        Collections.sort(ls,new SortWithSalary());
        ls.forEach(e-> System.out.println(e.salary));
        ls.add(new Employee(23,3234));
        ls.stream().sorted();
    }
}





