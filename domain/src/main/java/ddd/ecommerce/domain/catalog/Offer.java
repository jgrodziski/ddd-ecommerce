package ddd.ecommerce.domain.catalog;

import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.common.Quantity;
import ddd.ecommerce.domain.marketplace.VendorId;

/**
 * Created by jeremiegrodziski on 02/04/14.
 */
public class Offer {
    OfferId offerId;
    VendorId vendorId;
    String description;
    Quantity stock;
    Amount sellingPrice;

    public Offer(OfferId offerId, String description, Quantity stock, Amount sellingPrice, VendorId vendorId) {
        this.offerId = offerId;
        this.description = description;
        this.stock = stock;
        this.sellingPrice = sellingPrice;
        this.vendorId = vendorId;
    }

    public OfferId getId() {
        return offerId;
    }

    public String getDescription() {
        return description;
    }

    public Quantity getStock() {
        return stock;
    }

    public Amount getSellingPrice() {
        return sellingPrice;
    }

    public void decrementStock(Quantity quantityToRemove) {
        stock = stock.minus(quantityToRemove);
    }
}
