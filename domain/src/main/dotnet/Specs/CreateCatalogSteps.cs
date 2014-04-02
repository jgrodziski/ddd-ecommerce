using System;
using ECommerce.Core;
using TechTalk.SpecFlow;
using NUnit.Framework;

namespace ECommerce.Specs
{
    [Binding]
    public class CreateCatalogSteps
    {
        private readonly CatalogRepository repository = new CatalogRepository();
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
    }
}
