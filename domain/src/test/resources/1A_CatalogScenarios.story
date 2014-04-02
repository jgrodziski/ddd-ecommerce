When a manager creates a new catalog called "Seine"
Then the catalog "Seine" is available and online

Given a catalog without a MI (Music Instruments) universe
When I enter a new MI universe
Then the MI universe exist in the catalog

Given the MI universe without a GE (Guitar & Equipment) family 
When I enter a new GE family into the MI universe
Then the GE family exist in the MI universe

Given the GE family without a EG (Electric Guitars) category 
When I enter a new EG category into the GE family
Then the EG category exist in the GE family 

Given the GE family without a CG (Classic Guitars) category 
When I enter a new CG category into the GE family
Then the CG category exist in the GE family 

Given the GE family without a GA (Guitar Amplifiers) category
When I enter a new GA category into the GE family
Then the GA category exist in the GE family 










