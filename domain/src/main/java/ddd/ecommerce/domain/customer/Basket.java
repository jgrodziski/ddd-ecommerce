package ddd.ecommerce.domain.customer;

import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.catalog.OfferRepository;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketItem> items;

    public Basket() {
        items = new ArrayList<BasketItem>(2);
    }

    public void add(BasketItem basketItem){
        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public Amount calculateBalance(OfferRepository offerRepository){
        Amount balance = Amount.ZERO_EUR;
        for (BasketItem item : items) {
            balance.add(offerRepository.getOffer(item.getOfferId()).getSellingPrice());
        }
        return balance;
    }
}
