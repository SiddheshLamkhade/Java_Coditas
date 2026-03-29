package TaskTrackerPro;
class Sid {

    static void hello(){
        System.out.println("hello");
    }
    
}
class Child extends Sid{
     static void hello(){
        System.out.println("hello sid");
    }
}
class Main{
    public static void main(String[] args) {
        Sid obj= new Child();
        obj.hello();
    }
}