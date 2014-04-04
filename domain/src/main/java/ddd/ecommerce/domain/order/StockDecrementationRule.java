package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.catalog.Offer;
import ddd.ecommerce.domain.common.Quantity;

/**
 * Created by Training on 4/3/2014.
 */
public enum StockDecrementationRule {
    INSTANCE;
    public void decrementStock(Quantity quantityToRemove, Offer offer) {
        if(StockCheckRule.INSTANCE.checkStockAvailable( quantityToRemove, offer.getStock())) {
            offer.decrementStock(quantityToRemove);
        }
    }
}
