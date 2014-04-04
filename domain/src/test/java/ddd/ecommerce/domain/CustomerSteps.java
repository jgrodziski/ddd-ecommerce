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

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerSteps {
    OfferRepository offerRepository = new OfferRepositoryMock();
    Offer offer;
    Buyer buyer;
    Basket basket;

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

    @Then("le panier contient l'offre $offerId")
    public void thenLePanierContientLoffreEG1JAAvecUnSoldeDe5EUR(String offerId) {
        basket = buyer.getCurrentBasket();
        BasketItem item = basket.getItems().get(0);
        Amount balance = basket.calculateTotal(offerRepository);
        assertEquals(item.getOfferId(), new OfferId(offerId));
    }

    @Then("le panier a des frais de port de $amount $currency")
    public void thenLePanierADesFraisDePortOffert(String amount, String currency) {
        assertTrue(basket.getShippingCost().equals(new Amount(amount, "USD")));
    }

    @Then("le panier a un solde de $solde $currency")
    public void thenLePanierAUnSoldeDe49999USD(String solde, String currency) {
        //assertEquals(balance, new Amount(new BigDecimal(value), Currency.getInstance(currency)));
    }

}
