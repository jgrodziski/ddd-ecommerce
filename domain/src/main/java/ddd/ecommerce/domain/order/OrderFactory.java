package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.customer.BasketItem;
import ddd.ecommerce.domain.customer.Customer;

/**
 * Created by Training on 4/3/2014.
 */
public class OrderFactory {
    public static Order createOrder(Customer customer) {
        Order order = new Order(OrderStatus.SUBMITTED);
        order.setCustomerId(customer.getCustomerId());
        for (BasketItem item : customer.getCurrentBasket().getItems()) order.add(new OrderLine(item.getOfferId(), item.getQuantity()));
        return order;
    }
}
