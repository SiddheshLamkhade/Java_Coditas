package Week_4_Tasks.order;

import java.math.BigDecimal;
import java.util.List;

public class OrderApp {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order(1, "Siddhesh", BigDecimal.valueOf(6000), OrderType.ONLINE),
                new Order(2, "Rahul", BigDecimal.valueOf(3000), OrderType.OFFLINE),
                new Order(3, "Amit", BigDecimal.valueOf(8000), OrderType.ONLINE)
        );

        OrderService service = new OrderService();

        System.out.println("Total Revenue: " +
                service.calculateTotalRevenue(orders));

        System.out.println("Premium Orders: " +
                service.filterPremiumOrders(orders));

        System.out.println("Discounted Amount (Order 1): " +
                service.applyDiscount(orders.get(0)));
    }
}