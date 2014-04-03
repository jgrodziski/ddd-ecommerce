package ddd.ecommerce.domain.order;

/**
 * Created by Training on 4/3/2014.
 */
public interface OrderRepository {
    public void store(Order order);
    public Order findOrderById(OrderId orderId);
}
