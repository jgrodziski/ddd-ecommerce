Scenario: Play with Slot
When the following EGM is created: GTech, EMotion, denomination 0.5 EUR, 1000
Given the EGM 1000
When the player inserts a bill of 20 EUR
Then the EGM has an increment 40 credits
When the player bets 1 credit
Then the EGM starts a game with a bet of 1 credit
Then the EGM has a current balance of 39 credits
When the game is a success, the player wins 5 credits
Then the EGM has a balance of 44







