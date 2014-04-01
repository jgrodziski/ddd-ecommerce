package ddd.ecommerce.domain;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;

public class SlotSteps {
    EGM egm;
    EGMRepository repo = new EGMRepositoryMock();
    private Credit gain;

    @When("the following EGM is created: $brand, $model, denomination $denom $currency, $code")
    public void whenTheFollowingEGMIsCreatedGTechEMotion05Denomination1000(String brand, String mode, String denom, String currency, String code) {
        EGM egm = new EGM(brand, mode, new Denomination(new BigDecimal(denom), Currency.getInstance(currency)), new EGMCode(code));
        repo.store(egm);
    }

    @Given("the EGM $code")
    public void givenEGM(String code) {
        egm = repo.load(new EGMCode(code));
        assertNotNull("EGM with code " + code + " not found", egm);
    }

    @Then("the EGM is available with the code $code through the EGM repository")
    public void thenTheEGMIsAvailableWithTheCode1000ThroughTheEGMRepository(String code) {
        EGMCode egmCode = new EGMCode(code);
        EGM egm = repo.load(egmCode);
        assertNotNull(egm);
        assertThat(egm.getCode(), equalTo(new EGMCode(code)));
    }

    @When("the player inserts a bill of $value $currency")
    public void whenThePlayerInsertsABillOf(String value, String currencyCode) {
        egm.insert(new Bill(new Amount(new BigDecimal(value), Currency.getInstance(currencyCode))));
    }

    @Then("the EGM has an increment 40 credits")
    public void thenTheEGMHasAnIncrement40Credits() {
        Credit fourtyCredits = new Credit(40);
        assertThat(egm.getBalance(), equalTo(fourtyCredits));
    }

    @When("the player bets $betsValue credit")
    public void whenThePlayerBets1Credit(Integer betsValue) {
        egm.bet(new Credit(betsValue));
    }

    @Then("the EGM starts a game with a bet of $betsValue credit")
    public void thenTheEGMStartsAGameWithABetOf1Credit(Integer betsValue) {
        assertThat(egm.getBet(), equalTo(new Credit(betsValue)));
    }

    @Then("the EGM has a current balance of $balanceValue credits")
    public void thenTheEGMHasACurrentBalanceOf39Credits(Integer balanceValue) {
        assertThat(egm.getBalance(), equalTo(new Credit(balanceValue)));
    }

    @When("the game is a success, the player wins $winningCreditsValue credits")
    public void whenTheGameIsASuccessThePlayerWinsCredits(Integer winningCreditsValue) {
        Credit winningCredit = egm.spin();
        assertThat(winningCredit, equalTo(new Credit(winningCreditsValue)));
    }

    @Then("the EGM has a balance of $newBalanceValue")
    public void thenTheEGMHasABalanceOf(Integer newBalanceValue) {
        assertThat(egm.getBalance(), equalTo(new Credit(newBalanceValue)));
    }


    @Given("the EGM 1000")
    @Pending
    public void givenTheEGM1000() {
        // PENDING
    }


    EGM egm1001;

    @Given("the EGM 1001 with 80 credits and max credit of 100")
    @Pending
    public void givenTheEGM1001With80CreditsAndMaxCreditOf100() {
        egm1001 = repo.load(new EGMCode("1001"));
    }


    @When("the game is a success and the player wins 30 credits")
    @Pending
    public void whenThePlayerBets1CreditAndTheGameIsASuccessAndThePlayerWins30Credits() {
        egm1001.insert(new Bill(new Amount(new BigDecimal(20), Currency.getInstance(Locale.FRANCE))));
        egm1001.forceSuccess(1500);
        egm1001.bet(new Credit(1));
    }

    @Then("the EGM is blocked and the credit is equal to 129")
    @Pending
    public void thenTheEGMIsBlockedAndTheCreditIsEqualTo129() {
        assertThat(egm1001.isBlocked(), equalTo(true));
        assertThat(egm1001.getBalance(), equalTo(new Credit(1539)));
    }

}
