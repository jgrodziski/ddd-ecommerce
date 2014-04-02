Feature: Create Catalog
	Create catalog


@CreateCatalog
Scenario: Create Catalog
	Given a CatalogList without catalog "Seine" 
	When a manager creates a new catalog called "Seine"
	Then the catalog "Seine" is available in catalog list