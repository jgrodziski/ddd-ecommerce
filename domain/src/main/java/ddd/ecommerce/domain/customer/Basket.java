package ddd.ecommerce.domain.customer;

import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.catalog.OfferRepository;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketItem> items;
    private Amount shippingCost;

    public Basket() {
        items = new ArrayList<BasketItem>(2);
    }

    public void add(BasketItem basketItem){
        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public Amount calculateTotal(OfferRepository offerRepository){
        Amount balance = Amount.ZERO_USD;
        for (BasketItem item : items) {
            balance = balance.add(offerRepository.getOffer(item.getOfferId()).getSellingPrice());
        }
        //process the delivery cost
        shippingCost = new ShippingCostCalculator(null, null, balance).calculate();
        return balance.add(shippingCost);
    }

    public Amount getShippingCost() {
        return shippingCost;
    }


}
