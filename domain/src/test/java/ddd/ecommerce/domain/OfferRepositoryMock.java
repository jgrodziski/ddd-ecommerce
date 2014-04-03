package ddd.ecommerce.domain;

import ddd.ecommerce.domain.catalog.Offer;
import ddd.ecommerce.domain.catalog.OfferId;
import ddd.ecommerce.domain.catalog.OfferRepository;

import java.util.HashMap;
import java.util.Map;

public class OfferRepositoryMock implements OfferRepository {
    private static Map<OfferId, Offer> offers = new HashMap<OfferId, Offer>(10);

    @Override
    public Offer getOffer(OfferId offerId) {
        return offers.get(offerId);
    }

    public Offer store(Offer offer){
        offers.put(offer.getId(), offer);
        return offer;
    }
}
