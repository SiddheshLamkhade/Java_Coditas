package Week2Assigment1.Problem7;
//An enum is a special data type used to define a fixed set of named constants.
public enum  OrderStatus {

    PLACED("Order has been placed"),
    SHIPPED("Order has been shipped"),
    DELIVERED("Order has been delivered"),
    CANCELLED("Order has been cancelled");

//✔ These are enum constants
//✔ They are public static final by default
//✔ Each constant is actually an object of OrderStatus

    private String message;
//✔ Enums can have fields/variables
// VVIMP :  Each constant has its own value for this field

    OrderStatus(String message) {
        this.message = message;
    }
//✔ Constructor is implicitly private
//✔ Called once for each enum constant
//✔ Used to initialize fields/variables
//You cannot create enum objects manually using new

    public String getMessage() {
        return message; // it will return the message with the help of this method
    }

}
