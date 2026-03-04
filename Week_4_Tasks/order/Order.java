package Week_4_Tasks.order;

import java.math.BigDecimal;
import java.util.Objects;

public record Order(
        long id,
        String customerName,
        BigDecimal amount,
        OrderType type
) {
    public Order {
        Objects.requireNonNull(customerName, "Customer name cannot be null");
        Objects.requireNonNull(amount, "Amount cannot be null");
        Objects.requireNonNull(type, "Order type cannot be null");

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
