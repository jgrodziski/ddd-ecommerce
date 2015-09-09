package ddd.ecommerce.domain.order;

public interface OrderRepository {
    public void store(Order order);
    public Order get(OrderId orderId);
}
