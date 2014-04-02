using ECommerce.Core;
using NUnit.Framework;
using TechTalk.SpecFlow;

namespace ECommerce.Specs
{
    [Binding]
    public class VendorFeatureSteps
    {
        private readonly VendorRepository repository = new VendorRepository();

        [Given(@"a vendor list without a ""(.*)"" \(""(.*)""\) vendor")]
        public void GivenAVendorListWithoutAVendor(string code, string name)
        {
            var vendor = new Vendor(code, name);
            Assert.IsFalse(repository.Exist(vendor));
        }

        [When(@"I enter a new ""(.*)"" vendor with the name ""(.*)""")]
        public void WhenIEnterANewVendorWithTheName(string code, string name)
        {
            var vendor = new Vendor(code, name);
            repository.Add(vendor);
        }

        [Then(@"the ""(.*)"" vendor exist in the vendor list  with the name ""(.*)""")]
        public void ThenTheVendorExistInTheVendorListWithTheName(string code, string name)
        {
            var vendor = new Vendor(code, name);
            Assert.IsTrue(repository.Exist(vendor));
        }
    }
}
