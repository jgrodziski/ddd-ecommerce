package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.catalog.Offer;
import ddd.ecommerce.domain.catalog.OfferRepository;
import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.customer.Basket;
import ddd.ecommerce.domain.customer.BasketItem;
import ddd.ecommerce.domain.customer.CustomerId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

public class Order {
    private OrderId orderId = new OrderId(UUID.randomUUID().toString());
    private OfferRepository offerRepository = null;
    private OrderStatus orderStatus;
    private CustomerId customerId;
    private List<OrderLine> orderLines;
    private Amount price;


    public void add(OrderLine orderLine){
        orderLines.add(orderLine);
    }

    public Order(OrderStatus orderStatus) {
        orderLines = new ArrayList<OrderLine>(2);
        this.orderStatus=orderStatus;
    }

    public Amount getPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderLine orderLine : orderLines) {
            Offer offer = offerRepository.getOffer(orderLine.getOfferId());
            BigDecimal orderLinePrice = offer.getSellingPrice().getValue().multiply(new BigDecimal(String.valueOf(orderLine.getQuantity())));
            total.add(orderLinePrice);
        }
        return new Amount(total);
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
