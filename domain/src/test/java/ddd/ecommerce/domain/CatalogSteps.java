package ddd.ecommerce.domain;


import ddd.ecommerce.domain.catalog.*;
import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.common.Quantity;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class CatalogSteps {
    Catalog catalog;
    private CatalogRepository catalogRepository = new CatalogRepositoryMock();
    private VendorRepository vendorRepository= new VendorRepository() {
        Map<VendorId, Vendor> vendors = new HashMap<VendorId, Vendor>();
        @Override
        public void store(Vendor vendor) {
            vendors.put(vendor.getVendorId(), vendor);
        }

        @Override
        public Vendor get(VendorId vendorId) {
            return vendors.get(vendorId);
        }
    };
    OfferRepository offerRepository = new OfferRepositoryMock();

    @When("a manager creates a new catalog called \"$catalog\"")
    public void whenAManagerCreatesANewCatalog(String catalogName) {
        catalog = new Catalog(catalogName);
        catalogRepository.store(catalog);
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
        catalogRepository.store(catalog);

    }

    @Then("the $categoryId category exist in the $familyId family and $universeId universe")
    public void thenTheEGCategoryExistInTheGEFamily(String categoryId, String familyId, String universeId) {
        assertNotNull(catalog.getUniverse(universeId).getFamily(familyId).getCategory(categoryId));
    }

    @Given("the $categoryId category without a $productId product")
    public void givenTheEGCategoryWithoutAEG1Product(String categoryId, String productId) {
        // PENDING
    }

    @When("I enter a new $productId (\"$description\", \"$brand\", $asin, \"$weight\", \"$dimension\") product into the $universeId-$familyId-$categoryId category")
    public void whenIEnterANewProductIntoCategory(String productId, String description, String brand, String asin, String weight, String dimension, String universeId, String familyId, String categoryId) {
        Category category = catalog.getUniverse(universeId).getFamily(familyId).getCategory(categoryId);
        Product product = new Product(new ProductId(productId), description, brand, asin, weight, dimension, category);
        catalog.add(product);
        catalogRepository.store(catalog);
    }

    @Then("the $productId product exist in the $categoryId category")
    public void thenTheEG1ProductExistInTheEGCategory(String productId) {
        // PENDING
    }

    @Given("a vendor list without a $vendorId vendor")
    public void givenAVendorListWithoutAJAVendor() {
        // PENDING
    }

    @When("I enter a new $vendorId ($vendorName) vendor")
    public void whenIEnterANewJAJaneVendor(String vendorId, String vendorName) {
        Vendor vendor = new Vendor(new VendorId(vendorId), vendorName);
        vendorRepository.store(vendor);
    }

    @Then("the $vendorId vendor exist in the vendor list")
    public void thenTheJAVendorExistInTheVendorList(String vendorId) {

    }

    @Given("the $productId product exist")
    public void givenTheEG1ProductExist(String productId) {
        catalog.get(new ProductId(productId));
    }

    @Given("the $vendorId vendor exist")
    public void givenTheJAVendorExist(String vendorId) {

    }

    @When("I enter a new $offerId offer with the $productId product ($stock,$price,$currency), the $vendorId vendor")
    public void whenIEnterANewOffer(String offerId, String productId, String stock, String price, String currency, String vendorId) {
        Vendor vendor = vendorRepository.get(new VendorId(vendorId));
        Product product = catalog.get(new ProductId(productId));
        Offer offer = new Offer(new OfferId(offerId), product.getDescription(), new Quantity(Integer.valueOf(stock)), new Amount(new BigDecimal(price), Currency.getInstance(currency)), vendor.getVendorId());
        offerRepository.store(offer);
    }

    @Then("the $offerId offer exist in offer list")
    public void thenTheEG1JAProductExistInOfferListWithTheEG1Product105EURTheJAVendor() {
        // PENDING
    }



}
