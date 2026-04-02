package Week2Assigment1.Problem5;

public class MethodPassing {

    // Method to modify a primitive variable
    static void modifyPrimitive(int num) {
        num = num + 10;
        System.out.println("Inside modifyPrimitive: num =" + num);
    }

    // Method to modify an object’s internal state
    static void modifyObject(Person p) {
        p.age = p.age + 5;
        System.out.println("Inside modifyObject: age =" + p.age);
    }

    public static void main(String[] args) {
        // 1. Primitive example
        int number = 20;
        System.out.println("Before modifyPrimitive: number = " + number);
        modifyPrimitive(number);
        System.out.println("After modifyPrimitive: number = " + number);
        System.out.println("--------------------------------");

        // 2. Object example
        Person person = new Person("Alice", 25);
        System.out.println("Before modifyObject: age =" + person.age);
        modifyObject(person);
        System.out.println("After modifyObject: age = " + person.age);
    }
}

// Simple Person class
class
Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }
}

