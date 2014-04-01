Scenario: EGM Creation
When the following EGM is created: GTech, EMotion, denomination 0.5 EUR, 1000
Then the EGM is available with the code 1000 through the EGM repository
When the following EGM is created: GTech, EMotion, denomination 0.5 EUR, 1001, max credit 1000
Then the EGM is available with the code 1001 through the EGM repository
When the following EGM is created: GTech, EMotion, denomination 0.5 EUR, 1002
Then the EGM is available with the code 1002 through the EGM repository