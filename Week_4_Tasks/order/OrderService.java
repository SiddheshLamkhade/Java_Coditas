package Week_4_Tasks.order;

import java.math.BigDecimal;
import java.util.List;

public class OrderService {

    public BigDecimal calculateTotalRevenue(List<Order> orders) {
        return orders.stream()
                .map(Order::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Order> filterPremiumOrders(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.amount().compareTo(BigDecimal.valueOf(5000)) > 0)
                .toList();
    }

    public BigDecimal applyDiscount(Order order) {
        BigDecimal discountRate = switch (order.type()) {
            case ONLINE -> BigDecimal.valueOf(0.10);
            case OFFLINE -> BigDecimal.valueOf(0.05);
        };

        return order.amount()
                .subtract(order.amount().multiply(discountRate));
    }
}
