package ddd.ecommerce.domain;

import ddd.ecommerce.domain.order.Order;
import ddd.ecommerce.domain.order.OrderId;
import ddd.ecommerce.domain.order.OrderRepository;

import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryMock implements OrderRepository {
    private final static Map<OrderId, Order> orders = new HashMap<OrderId, Order>(10);

    @Override
    public void store(Order order) {
        orders.put(order.getOrderId(), order);
    }

    @Override
    public Order get(OrderId orderId) {
        return orders.get(orderId);
    }
}
