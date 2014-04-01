Scenario: Blocking game with slot
Given the EGM 1001
When the player insert a bill of 20 euros and the player bets 1 credit and the game is a success and the player wins 1500 credits
Then the EGM is blocked and the credit is equal to 1539
