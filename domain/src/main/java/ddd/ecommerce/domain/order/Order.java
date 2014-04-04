package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.customer.Basket;
import ddd.ecommerce.domain.customer.BasketItem;
import ddd.ecommerce.domain.customer.CustomerId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Training on 4/3/2014.
 */
public class Order {
    private OrderId orderId = new OrderId(UUID.randomUUID().toString());
    private OrderStatus orderStatus;
    private CustomerId customerId;
    private List<OrderLine> orderLines;
    private OrderTotal price;


    public void add(OrderLine orderLine){
        orderLines.add(orderLine);
    }

    public Order(OrderStatus orderStatus) {
        orderLines = new ArrayList<OrderLine>(2);
        this.orderStatus=orderStatus;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

     void setCustomerId(CustomerId customerId) {
        this.customerId= customerId;
    }

    public void changeStatus(OrderStatus orderStatus) {
        // here business logic
        this.orderStatus = orderStatus;
    }

}
