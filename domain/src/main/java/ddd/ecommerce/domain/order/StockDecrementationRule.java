package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.catalog.Offer;
import ddd.ecommerce.domain.catalog.Stock;
import ddd.ecommerce.domain.common.Quantity;
import ddd.ecommerce.domain.common.Rule;

public class StockDecrementationRule implements Rule<Quantity> {
    Quantity quantityToRemove;
    Offer offer;

    public StockDecrementationRule(Quantity quantityToRemove, Offer offer) {
        this.quantityToRemove = quantityToRemove;
        this.offer = offer;
    }

    @Override
    public Quantity evaluate() {
        if(new StockCheckRule(quantityToRemove, offer.getStock()).isTrue()) {
            offer.decrementStock(quantityToRemove);
        }
        return offer.getStock();
    }
}
