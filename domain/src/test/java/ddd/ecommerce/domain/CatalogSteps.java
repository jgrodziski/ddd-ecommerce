package ddd.ecommerce.domain;


import ddd.ecommerce.domain.catalog.Catalog;
import ddd.ecommerce.domain.catalog.Category;
import ddd.ecommerce.domain.catalog.Family;
import ddd.ecommerce.domain.catalog.Universe;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class CatalogSteps {
    Catalog catalog;
    private CatalogRepository catalogRepository = new CatalogRepositoryMock();

    @When("a manager creates a new catalog called \"$catalog\"")
    public void whenAManagerCreatesANewCatalog(String catalogName) {
        catalog = new Catalog(catalogName);
    }

    @Then("the catalog \"Seine\" is available and online")
    public void thenTheCatalogSeineIsAvailableAndOnline() {

    }

    @Given("a catalog without a $universeId universe")
    public void givenACatalogWithoutAMIMusicInstrumentsUniverse() {
        // PENDING
    }

    @When("I enter a new $code ($label) universe")
    public void whenIEnterANewMIUniverse(String code, String label) {
        catalog.add(new Universe(code, label));
        catalogRepository.store(catalog);
    }

    @Then("the $universeId universe exist in the catalog")
    public void thenTheMIUniverseExistInTheCatalog(String universeId) {
        assertNotNull(catalog.getUniverse(universeId));
    }

    @Given("the $universeId universe without a $familyId family")
    public void givenTheMIUniverseWithoutAGEGuitarEquipmentFamily(String universeId, String familyId) {
        // PENDING
    }

    @When("I enter a new $code ($label) family into the $universeId universe")
    public void whenIEnterANewGEFamilyIntoTheMIUniverse(String code, String label, String universeId) {
        Universe universe = catalog.getUniverse(universeId);
        universe.add(new Family(code, label, universe));
        catalogRepository.store(catalog);
    }

    @Then("the $familyId family exist in the $universeId universe")
    public void thenTheGEFamilyExistInTheMIUniverse() {

    }

    @Given("the $familyId family without a $categoryId category")
    public void givenTheGEFamilyWithoutAEGElectricGuitarsCategory() {
        // PENDING
    }

    @When("I enter a new $code ($label) category into the $familyId family and $universeId universe")
    public void whenIEnterANewEGCategoryIntoTheGEFamily(String code, String label, String familyId, String universeId) {
        Family family = catalog.getUniverse(universeId).getFamily(familyId);
        family.add(new Category(code, label, family));
    }

    @Then("the $categoryId category exist in the $familyId family and $universeId universe")
    public void thenTheEGCategoryExistInTheGEFamily(String categoryId, String familyId, String universeId) {
        assertNotNull(catalog.getUniverse(universeId).getFamily(familyId).getCategory(categoryId));
    }




}
