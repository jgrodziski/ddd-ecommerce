package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.catalog.Offer;
import ddd.ecommerce.domain.common.Quantity;

public class StockDecrementationRule {

    public void decrementStock(Quantity quantityToRemove, Offer offer) {
        if(new StockCheckRule(quantityToRemove, offer.getStock()).isTrue()) {
            offer.decrementStock(quantityToRemove);
        }
    }
}
