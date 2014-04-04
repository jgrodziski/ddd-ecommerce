package ddd.ecommerce.domain.customer;

import java.util.UUID;

/**
 * Created by jeremiegrodziski on 02/04/14.
 */
public class Buyer {
    Basket basket = new Basket();
    BuyerId id = new BuyerId(UUID.randomUUID().toString());

    public BuyerId getId(){
        return id;
    }

    public Basket getCurrentBasket(){
        return basket;
    }
}
