Feature: VendorFeature
	Vendors creation process

@mytag
Scenario: Create vendor
	Given a vendor list without a "JA" ("Jane") vendor 
	When I enter a new "JA" vendor with the name "Jane"
	Then the "JA" vendor exist in the vendor list  with the name "Jane"