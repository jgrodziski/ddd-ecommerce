package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.catalog.OfferId;
import ddd.ecommerce.domain.common.Quantity;

/**
 * Created by Training on 4/3/2014.
 */
public enum StockCheckRule {
    INSTANCE;
    /**
     * On vérifie que la quantité du produit demandé dans notre OrderLine est disponible
     */
    public boolean checkStockAvailable(Quantity orderLineQuantity, Quantity stockQuantity) {
        return orderLineQuantity.lte(stockQuantity);
    }
}
