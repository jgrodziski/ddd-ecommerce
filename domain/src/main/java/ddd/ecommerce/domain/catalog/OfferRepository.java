package ddd.ecommerce.domain.catalog;


public interface OfferRepository {

    public Offer getOffer(OfferId offerId);
    public void store(Offer offer);
}
