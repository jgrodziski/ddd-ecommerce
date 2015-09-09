package ddd.ecommerce.domain.common;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

public class AmountTest {

    @Test
    public void testSubstract() {

        Currency EUR = Currency.getInstance("EUR");
        Amount amount1= new Amount(BigDecimal.valueOf(25.0), EUR);
        Amount amount2= new Amount(BigDecimal.valueOf(10.0), EUR);

        Amount result = amount1.subtract(amount2);

        Assert.assertEquals(15.0, result.getValue().doubleValue(), 2E-15);

        Assert.assertEquals(EUR, result.getCurrency());

    }
}
