Scenario: catalog creation
When a manager creates a new catalog called "Seine"
Then the catalog "Seine" is available and online

Scenario: category system creation
Given a catalog called "Seine"
When a manager creates a universe "Instruments de Musique", code MI
Then the universe MI is available
When a manager creates a family "Guitares", code GU with parent universe MI
Then the family GU is available
When a manager creates a category "Guitares Electriques", code GE with parent family GU
Then the category GE is available
When a manager creates a category "Guitares Classiques", code GC with family GU
Then the category GC is available
When a manager creates a category "Amplificateurs pour Guitare", code AG with parent family GU
Then the category AG is available



