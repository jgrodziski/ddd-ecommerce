package ddd.ecommerce.domain.common;

import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 */
public class Amount {
    private BigDecimal value;
    private Currency currency;
    public static final Amount ZERO_EUR = new Amount(BigDecimal.ZERO, Currency.getInstance("EUR"));

    public Amount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Amount add(Amount otherAmount){
        if (!this.getCurrency().equals(otherAmount.getCurrency())) throw new RuntimeException("Currency must be identical");
        return new Amount(this.value.add(otherAmount.getValue()), getCurrency());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        if (currency != null ? !currency.equals(amount.currency) : amount.currency != null) return false;
        if (value != null ? !value.equals(amount.value) : amount.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
