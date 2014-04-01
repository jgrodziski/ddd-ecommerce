Scenario: Play with Slot
Given an available EGM (Electronic Game Machine) with a denomination of 0.5 EUR and no credits
When the player inserts a bill of 20 EUR
Then a new session is started
Then the EGM has an increment 40 credits
When the player bets 1 credit
Then the EGM starts a game with a bet of 1 credit
Then the EGM returns the game result
