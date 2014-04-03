package ddd.ecommerce.domain;


import ddd.ecommerce.domain.catalog.Catalog;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class CatalogSteps {
    Catalog catalog;

    @When("a manager creates a new catalog called \"$catalog\"")
    public void whenAManagerCreatesANewCatalog(String catalogName) {
        catalog = new Catalog(catalogName);
    }

    @Then("the catalog \"Seine\" is available and online")
    @Pending
    public void thenTheCatalogSeineIsAvailableAndOnline() {

    }

    @Given("a catalog without a MI (Music Instruments) universe")
    @Pending
    public void givenACatalogWithoutAMIMusicInstrumentsUniverse() {
        // PENDING
    }

    @When("I enter a new MI universe")
    @Pending
    public void whenIEnterANewMIUniverse() {
        //catalog.add(new Universe())
    }

    @Then("the MI universe exist in the catalog")
    @Pending
    public void thenTheMIUniverseExistInTheCatalog() {
        // PENDING
    }

    @Given("the MI universe without a GE (Guitar & Equipment) family")
    @Pending
    public void givenTheMIUniverseWithoutAGEGuitarEquipmentFamily() {
        // PENDING
    }

    @When("I enter a new GE family into the MI universe")
    @Pending
    public void whenIEnterANewGEFamilyIntoTheMIUniverse() {
        // PENDING
    }

    @Then("the GE family exist in the MI universe")
    @Pending
    public void thenTheGEFamilyExistInTheMIUniverse() {
        // PENDING
    }

    @Given("the GE family without a EG (Electric Guitars) category")
    @Pending
    public void givenTheGEFamilyWithoutAEGElectricGuitarsCategory() {
        // PENDING
    }

    @When("I enter a new EG category into the GE family")
    @Pending
    public void whenIEnterANewEGCategoryIntoTheGEFamily() {
        // PENDING
    }


}
