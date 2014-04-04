package ddd.ecommerce.domain.customer;

import ddd.ecommerce.domain.catalog.OfferId;
import ddd.ecommerce.domain.common.Quantity;
import org.joda.time.Instant;

public class BasketItem {
    OfferId offerId;
    String offerDescription;
    Quantity quantity;
    Instant creationInstant;

    public BasketItem(OfferId offerId, String offerDescription, Quantity quantity) {
        this.offerId = offerId;
        this.offerDescription = offerDescription;
        this.quantity = quantity;
        creationInstant = Instant.now();
    }

    public OfferId getOfferId() {
        return offerId;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Instant getCreationInstant() {
        return creationInstant;
    }
}
