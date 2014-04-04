package ddd.ecommerce.domain.customer;

/**
 * Created by Training on 4/3/2014.
 */
public class Customer {
    private CustomerId customerId;
    private Basket basket;

    public CustomerId getCustomerId() {
        return customerId;
    }

    public Basket getCurrentBasket(){
        return basket;
    }

    public void submitBasket() {
    }
}
