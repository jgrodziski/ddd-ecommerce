package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.common.Address;
import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.common.AmountCalculator;
import ddd.ecommerce.domain.common.Weight;
import ddd.ecommerce.domain.order.FreeShippingCostRule;

import java.math.BigDecimal;
import java.util.Currency;

public class ShippingCostCalculator implements AmountCalculator {
    private Address address;
    private Weight totalWeight;
    private FreeShippingCostRule freeShippingCostRule;
    public static final Amount minimumBalanceForFreeDeliveryCost = new Amount(200,"USD");

    public ShippingCostCalculator(Address address, Weight totalWeight, Amount balance) {
        this.address = address;
        this.totalWeight = totalWeight;
        freeShippingCostRule = new FreeShippingCostRule(balance, minimumBalanceForFreeDeliveryCost);
    }

    @Override
    public Amount evaluate() {
        return calculate();
    }

    @Override
    public Amount calculate() {
        if (freeShippingCostRule.isTrue())
            return Amount.ZERO_USD;
        else
            return new Amount(BigDecimal.TEN, Currency.getInstance("USD"));
    }
}
