Feature: Create Catalog

Scenario: Create Catalog
	Given a CatalogList without catalog "Seine" 
	When a manager creates a new catalog called "Seine"
	Then the catalog "Seine" is available in catalog list

	Given catalog "Seine" without a "MI" ("Music Instruments") universe
	When I enter a new "MI" universe with the "Music Instruments" description into the catalog "Seine"
	Then the "MI" universe with the "Music Instruments" description exist in the  "Seine" catalog

	Given the "MI" universe without a "GE" ("Guitar & Equipment") family 
	When I enter a new "GE" family with "Guitar & Equipment" description into the "MI" universe
	Then the "GE" family exist in the "MI" universe

	Given the "GE" family without a "EG" ("Electric Guitars") category 
	When I enter a new "EG" category with the "Electric Guitars" description into the "GE" family
	Then the "EG" category exist in the "GE" family with the "Electric Guitars" description

	Given the "GE" family without a "CG" ("Classic Guitars") category 
	When I enter a new "CG" category with the "Classic Guitars" description into the "GE" family
	Then the "CG" category exist in the "GE" family with the "Classic Guitars" description

	Given the "GE" family without a "GA" ("Guitar Amplifiers") category 
	When I enter a new "GA" category with the "Guitar Amplifiers" description into the "GE" family
	Then the "GA" category exist in the "GE" family with the "Guitar Amplifiers" description





