package ddd.ecommerce.domain;

import ddd.ecommerce.domain.catalog.*;
import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.customer.Customer;
import ddd.ecommerce.domain.order.*;
import ddd.ecommerce.domain.payment.ChargeResponse;
import ddd.ecommerce.domain.payment.CreditCardInfo;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.UUID;


public class OrderSteps {
    Catalog catalog;
    private CatalogRepository catalogRepository = new CatalogRepositoryMock();
    private OrderRepository orderRepository = new OrderRepositoryMock();
    private Order order;
    private Customer customer;
    private PaymentService paymentService = new PaymentService() {
        @Override
        public ChargeResponse charge(CreditCardInfo creditCardInfo, Amount amount, String description) {
            return new ChargeResponse(UUID.randomUUID().toString(), true);
        }
    };

    @Given("service de commande initialise avec un catalogue et un service client")
    public void givenServiceDeCommandeInitialiseAvecUnCatalogueEtUnServiceClient() {
       // PENDING

    }

    @Given("le panier courant du compte client \"jeremie@grodziski.com\"")
    public void givenLePanierCourantDuCompteClientjeremiegrodziskicom() {
        // PENDING
    }

    @When("le client soumet le panier")
    public void whenLeClientSoumetLePanier() {
        customer.submitBasket();
    }

    @Then("la commande est creee dans l'etat \"SUBMITTED\"")
    public void thenLaCommandeEstCreeeDansLetatSUBMITTED() {
        // PENDING
        order = OrderFactory.createOrder(customer);
        orderRepository.store(order);

        Assert.assertEquals(OrderStatus.SUBMITTED, order.getOrderStatus());
        Assert.assertNotNull(orderRepository.get(order.getOrderId()));
        Assert.assertEquals(OrderStatus.SUBMITTED, orderRepository.get(order.getOrderId()).getOrderStatus());
    }

    @Then("le recapitulatif de la commande est affichee au client")
    public void thenLeRecapitulatifDeLaCommandeEstAfficheeAuClient() {
        // PENDING
    }

    @Given("la commande dans l'etat \"SUBMITTED\"")
    public void givenLaCommandeDansLetatSUBMITTED() {
        // PENDING
    }

    @When("le client demarre le processus de paiement")
    public void whenLeClientDemarreLeProcessusDePaiement() {
    }

    @Then("le systeme verifie que le stock des offres de la commande est suffisant pour les quantites")
    public void thenLeSystemeVerifieQueLeStockDesOffresDeLaCommandeEstSuffisantPourLesQuantites() {
    }

    @Then("le systeme demande au client de choisir parmi les modes de paiements : CB, VIREMENT, CHEQUE")
    public void thenLeSystemeDemandeAuClientDeChoisirParmiLesModesDePaiementsCBVIREMENTCHEQUE() {
    }

    @When("le client choisit le mode de paiement CB")
    public void whenLeClientChoisitLeModeDePaiementCB() {
    }

    @Then("le systeme demande au client de renseigner ses informations CB")
    public void thenLeSystemeDemandeAuClientDeRenseignerSesInformationsCB() {
    }

    CreditCardInfo creditCardInfo;
    @When("le client saisit ses informations CB $creditCardNumber, $cvc, $expirationDate")
    public void whenLeClientSaisitSesInformationsCB(String creditCardNumber, String CVC, String expirationDate) {
        creditCardInfo= new CreditCardInfo(creditCardNumber, CVC, expirationDate);
    }

    ChargeResponse chargeResponse;
    @Then("le systeme a valide le paiement")
    public void thenLeSystemeAValideLePaiement() {
        chargeResponse = paymentService.charge(creditCardInfo,order.getPrice(), "");
        Assert.assertTrue(chargeResponse.isPaid());
    }

    @Then("la commande est dans l'etat \"PAID\"")
    public void thenLaCommandeEstDansLetatPAID() {
        // PENDING
        order.changeStatus(OrderStatus.PAID);
        orderRepository.store(order);

        Assert.assertEquals(OrderStatus.PAID, order.getOrderStatus());
        Assert.assertNotNull(orderRepository.get(order.getOrderId()));
        Assert.assertEquals(OrderStatus.PAID, orderRepository.get(order.getOrderId()).getOrderStatus());
    }

    @Then("la facture est emise")
    public void thenLaFactureEstEmise() {
        // PENDING
    }
}
