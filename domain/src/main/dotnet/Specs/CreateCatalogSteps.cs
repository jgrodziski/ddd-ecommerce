using System.ComponentModel;
using System.Linq;
using ECommerce.Core;
using NUnit.Framework;
using TechTalk.SpecFlow;

[Binding]
public class CreateCatalogSteps
{
    private readonly CatalogRepository repository = new CatalogRepository();

    #region Create Catalog
    [Given(@"a CatalogList without catalog ""(.*)""")]
    public void GivenACatalogListWithoutCatalog(string name)
    {
        var catalog = new Catalog(name);
        Assert.IsFalse(repository.Exist(catalog));
    }

    [When(@"a manager creates a new catalog called ""(.*)""")]
    public void WhenAManagerCreatesANewCatalogCalled(string name)
    {
        var catalog = new Catalog(name);
        repository.Add(catalog);
    }

    [Then(@"the catalog ""(.*)"" is available in catalog list")]
    public void ThenTheCatalogIsAvailableInCatalogList(string name)
    {
        var catalog = new Catalog(name);
        Assert.IsTrue(repository.Exist(catalog));
    } 
    #endregion

    #region Create Universe

    [Given(@"catalog ""(.*)"" without a ""(.*)"" \(""(.*)""\) universe")]
    public void GivenCatalogWithoutAUniverse(string catalogName, string universeName, string description)
    {
        var catalog = repository.GetByName(catalogName);
        Assert.IsFalse(catalog.Universes.Any(item => item.Name == universeName));
    }

    [When(@"I enter a new ""(.*)"" universe with the ""(.*)"" description into the catalog ""(.*)""")]
    public void WhenIEnterANewUniverseWithTheDescriptionIntoTheCatalog(string universeName, string universeDescription, string catalogName)
    {
        var catalog = repository.GetByName(catalogName);
        Assert.IsNotNull(catalog);
        catalog.AddUniverse(new Universe(universeName, universeDescription));
    }

    [Then(@"the ""(.*)"" universe with the ""(.*)"" description exist in the  ""(.*)"" catalog")]
    public void ThenTheUniverseExistInTheCatalog(string name, string description, string catalogName)
    {
        var catalog = repository.GetByName(catalogName);
        Universe universe = catalog.Universes.First(item => item.Name == name && item.Description == description);
        Assert.IsNotNull(universe);
    }

    #endregion

    #region Create Family

    [Given(@"the ""(.*)"" universe without a ""(.*)"" \(""(.*)""\) family")]
    public void GivenTheUniverseWithoutAFamily(string universeName, string familyName, string familyDescription)
    {
        var catalogs = repository.FindAll();
        var universe = catalogs.SelectMany(item => item.Universes).FirstOrDefault(x => x.Name == universeName);
        Assert.IsNotNull(universe);
        Assert.IsFalse(universe.Families.Any(item => item.Name == familyName));
    }

    [When(@"I enter a new ""(.*)"" family with ""(.*)"" description into the ""(.*)"" universe")]
    public void WhenIEnterANewFamilyIntoTheUniverse(string familyName, string description, string universeName)
    {
        var catalogs = repository.FindAll();
        var universe = catalogs.SelectMany(item => item.Universes).FirstOrDefault(x => x.Name == universeName);
        var family = new Family(familyName, description);
        universe.AddFamily(family);
    }

    [Then(@"the ""(.*)"" family exist in the ""(.*)"" universe")]
    public void ThenTheFamilyExistInTheUniverse(string familyName, string universeName)
    {
        var catalogs = repository.FindAll();
        var universe = catalogs.SelectMany(item => item.Universes).FirstOrDefault(x => x.Name == universeName);
        Assert.IsNotNull(universe);
        Family family = universe.Families.First(item => item.Name == familyName);
        Assert.IsNotNull(family);
    }

    #endregion

    #region Categories

    [Given(@"the ""(.*)"" family without a ""(.*)"" \(""(.*)""\) category")]
    public void GivenTheFamilyWithoutACategory(string familyName, string categoryName, string categoryDescription)
    {
        var family = repository.GetFamily(familyName);
        Assert.IsFalse(family.Categories.Any(item => item.Name == categoryName));
    }

    [When(@"I enter a new ""(.*)"" category with the ""(.*)"" description into the ""(.*)"" family")]
    public void WhenIEnterANewCategoryIntoTheFamily(string categoryName, string description, string familyName)
    {
        var family = repository.GetFamily(familyName);
        family.AddCategory(new Category(categoryName, description));
    }

    [Then(@"the ""(.*)"" category exist in the ""(.*)"" family with the ""(.*)"" description")]
    public void ThenTheCategoryExistInTheFamily(string categoryName, string familyName, string description)
    {
        var family = repository.GetFamily(familyName);
        Assert.IsTrue(family.Categories.Any(item => item.Name == categoryName && item.Description == description));
    }

    #endregion



}