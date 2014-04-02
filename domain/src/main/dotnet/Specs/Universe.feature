Feature: Universe
	Create Universe

@CreateUniverse
Scenario: Create Universe
	Given a catalog "Seine" without a "MI" ("Music Instruments") universe
	When I enter a new "MI" universe
	Then the "MI" ("Music Instruments") universe exist in the catalog "Seine"
