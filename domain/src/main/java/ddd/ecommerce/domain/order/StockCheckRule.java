package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.catalog.OfferId;
import ddd.ecommerce.domain.common.BooleanRule;
import ddd.ecommerce.domain.common.Quantity;

/**
 * On vérifie que la quantité du produit demandé dans notre OrderLine est disponible
 */
public class StockCheckRule implements BooleanRule {
    private Quantity orderLineQuantity;
    private Quantity stockQuantity;

    public StockCheckRule(Quantity orderLineQuantity, Quantity stockQuantity) {
        this.orderLineQuantity = orderLineQuantity;
        this.stockQuantity = stockQuantity;
    }

    public boolean checkStockAvailable() {
        return orderLineQuantity.lte(stockQuantity);
    }

    @Override
    public boolean isTrue() {
        return checkStockAvailable();
    }
}
