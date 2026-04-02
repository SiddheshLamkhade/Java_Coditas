package Week2Assigment1.Problem7;

public class
OrderTest {

    public static void main(String[] args) {

        OrderStatus status = OrderStatus.PLACED;
        // status variable is a type of OrderStatus and in that I have stored its element

        System.out.println("Order Status: " + status);
        System.out.println("Message: " + status.getMessage());

        // Changing status
        status = OrderStatus.SHIPPED;
        System.out.println("----------------------------------");
        System.out.println("Order Status: " + status);
        System.out.println("Message: " + status.getMessage());

        for(OrderStatus s: OrderStatus.values()){
            System.out.println(s + "    " +s.getMessage());
        }
    }
}

