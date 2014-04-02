Given the EG1 product exist
And the JA vendor exist
When I enter a new EG1-JA offer the EG1 product (10,5,EUR), the JA vendor
Then the EG1-JA product exist in offer list with the EG1 product (10,5,EUR), the JA vendor

Given the CG1 product exist
And the JA vendor exist
When I enter a new CG1-JA offer with the CG1 product (15,10,EUR), the JA vendor
Then the CG1-JA product exist in offer list with the CG1 product (15,10,EUR), the JA vendor

Given the GA1 product exist
And the JA vendor exist
When I enter a new GA1-JA offer with the GA1 product (20,15,EUR), the JA vendor
Then the GA1-JA product exist in offer list with the GA1 product (20,15,EUR), the JA vendor