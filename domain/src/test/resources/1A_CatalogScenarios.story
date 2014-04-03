When a manager creates a new catalog called "Seine"
Then the catalog "Seine" is available and online

Given a catalog without a MI universe
When I enter a new MI (Music Instruments) universe
Then the MI universe exist in the catalog

Given the MI universe without a GE family
When I enter a new GE (Guitar & Equipment) family into the MI universe
Then the GE family exist in the MI universe

Given the GE family without a EG category
When I enter a new EG (Electric Guitars) category into the GE family and MI universe
Then the EG category exist in the GE family and MI universe

Given the GE family without a CG category
When I enter a new CG (Classic Guitars) category into the GE family and MI universe
Then the CG category exist in the GE family and MI universe

Given the GE family without a GA category
When I enter a new GA (Guitar Amplifiers) category into the GE family and MI universe
Then the GA category exist in the GE family and MI universe










