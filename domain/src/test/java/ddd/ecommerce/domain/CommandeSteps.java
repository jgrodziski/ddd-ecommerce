package ddd.ecommerce.domain;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Training on 4/2/2014.
 */
public class CommandeSteps {

    @Given("service de commande initialise avec un catalogue et un service client")
    @Pending
    public void givenServiceDeCommandeInitialiseAvecUnCatalogueEtUnServiceClient() {
       // PENDING

    }

    @Given("le panier courant du compte client \"jeremie@grodziski.com\"")
    @Pending
    public void givenLePanierCourantDuCompteClientjeremiegrodziskicom() {
        // PENDING
    }

    @When("le client soumet le panier")
    @Pending
    public void whenLeClientSoumetLePanier() {
        // PENDING
    }

    @Then("la commande est creee dans l'etat \"SUBMITTED\"")
    @Pending
    public void thenLaCommandeEstCreeeDansLetatSUBMITTED() {
        // PENDING
    }

    @Then("le recapitulatif de la commande est affichee au client")
    @Pending
    public void thenLeRecapitulatifDeLaCommandeEstAfficheeAuClient() {
        // PENDING
    }

    @Given("la commande dans l'etat \"SUBMITTED\"")
    @Pending
    public void givenLaCommandeDansLetatSUBMITTED() {
        // PENDING
    }

    @When("le client demarre le processus de paiement")
    @Pending
    public void whenLeClientDemarreLeProcessusDePaiement() {
        // PENDING
    }

    @Then("le systeme verifie que le stock des offres de la commande est suffisant pour les quantites")
    @Pending
    public void thenLeSystemeVerifieQueLeStockDesOffresDeLaCommandeEstSuffisantPourLesQuantites() {
        // PENDING
    }

    @Then("le systeme demande au client de choisir parmi les modes de paiements : CB, VIREMENT, CHEQUE")
    @Pending
    public void thenLeSystemeDemandeAuClientDeChoisirParmiLesModesDePaiementsCBVIREMENTCHEQUE() {
        // PENDING
    }

    @When("le client choisit le mode de paiement CB")
    @Pending
    public void whenLeClientChoisitLeModeDePaiementCB() {
        // PENDING
    }

    @Then("le systeme demande au client de renseigner ses informations CB")
    @Pending
    public void thenLeSystemeDemandeAuClientDeRenseignerSesInformationsCB() {
        // PENDING
    }

    @When("le client saisit ses informations CB 1234 5678 9011 1213, 456, 04/15")
    @Pending
    public void whenLeClientSaisitSesInformationsCB12345678901112134560415() {
        // PENDING
    }

    @Then("le systeme a valide le paiement")
    @Pending
    public void thenLeSystemeAValideLePaiement() {
        // PENDING
    }

    @Then("la commande est dans l'etat \"PAID\"")
    @Pending
    public void thenLaCommandeEstDansLetatPAID() {
        // PENDING
    }

    @Then("la facture est emise")
    @Pending
    public void thenLaFactureEstEmise() {
        // PENDING
    }
}
