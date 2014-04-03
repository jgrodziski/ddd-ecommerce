package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.catalog.OfferId;
import ddd.ecommerce.domain.common.Quantity;

/**
 * Created by Training on 4/3/2014.
 */
public class OrderLine {
    OfferId offerId;
    Quantity quantity;

    public OrderLine(OfferId offerId, Quantity quantity) {
        this.offerId = offerId;
        this.quantity = quantity;
    }

    public OfferId getOfferId() {
        return offerId;
    }

    public Quantity getQuantity() {
        return quantity;
    }

}
