package ddd.ecommerce.domain.catalog;

import ddd.ecommerce.domain.common.Amount;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

public class CartEntryPriceTest {
    @Test
    public void testCartEntryPrice() {

        Currency EUR = Currency.getInstance("EUR");

        CartEntryPrice _25_EUROS_5_EURO_DISCTOUNT = new CartEntryPrice(new Amount(BigDecimal.valueOf(25.0), EUR), new Amount(BigDecimal.valueOf(5.0), EUR));


        CartEntryPrice _30_EUROS_15_EURO_DISCTOUNT = new CartEntryPrice(new Amount(BigDecimal.valueOf(30.0), EUR), new Amount(BigDecimal.valueOf(15.0), EUR));

        Assert.assertEquals(new Amount(BigDecimal.valueOf(20.0), EUR), _25_EUROS_5_EURO_DISCTOUNT.getAmountWithDiscouts());

        Assert.assertEquals(new Amount(BigDecimal.valueOf(15.0), EUR), _30_EUROS_15_EURO_DISCTOUNT.getAmountWithDiscouts());

    }
}
