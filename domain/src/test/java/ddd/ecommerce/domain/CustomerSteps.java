package ddd.ecommerce.domain;

import ddd.ecommerce.domain.catalog.Offer;
import ddd.ecommerce.domain.catalog.OfferId;
import ddd.ecommerce.domain.catalog.OfferRepository;
import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.common.Quantity;
import ddd.ecommerce.domain.customer.Basket;
import ddd.ecommerce.domain.customer.BasketItem;
import ddd.ecommerce.domain.customer.Buyer;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerSteps {
    OfferRepository offerRepository;
    Offer offer;
    Buyer buyer;

    @Given("l'offre $offerId")
    public void givenLoffreEG1JA(String offerId) {
        offer = offerRepository.getOffer(new OfferId(offerId));
    }

    @When("l'acheteur ajoute l'offre $offerId a son panier")
    public void whenLacheteurAjouteLoffreEG1JAASonPanier(String offerId) {
        buyer = new Buyer();
        buyer.getCurrentBasket().add(new BasketItem(offer.getId(), offer.getDescription(), Quantity.ONE));
    }

    @Then("l'acheteur recoit un token d'identification aleatoire")
    public void thenLacheteurRecoitLeTokenDidentification12345678ABC() {
        assertNotNull(buyer.getId());
    }

    @Then("le panier contient l'offre $offerId avec un solde de $value $currency")
    public void thenLePanierContientLoffreEG1JAAvecUnSoldeDe5EUR(String offerId, String value, String currency) {
        Basket basket = buyer.getCurrentBasket();
        BasketItem item = basket.getItems().get(0);
        Amount balance = basket.calculateBalance(offerRepository);
        assertEquals(item.getOfferId(), new OfferId(offerId));
        assertEquals(balance, new Amount(new BigDecimal(value), Currency.getInstance(currency)));
    }

}
