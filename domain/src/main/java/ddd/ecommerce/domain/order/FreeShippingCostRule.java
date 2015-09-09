package ddd.ecommerce.domain.order;

import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.common.BooleanRule;

/**
 * When basket balance &gt; a minimum amount
 * Then delivery costs are an amount 0 USD
 */
public class FreeShippingCostRule implements BooleanRule {
    private Amount basketBalance;
    private Amount minimumBalanceForFreeShippingCost;

    public FreeShippingCostRule(Amount basketBalance, Amount minimumBalanceForFreeShippingCost) {
        this.basketBalance = basketBalance;
        this.minimumBalanceForFreeShippingCost = minimumBalanceForFreeShippingCost;
    }

    @Override
    public Boolean evaluate() {
        return isShippingCostFree();
    }

    public boolean isShippingCostFree(){
        return basketBalance.getValue().compareTo(minimumBalanceForFreeShippingCost.getValue()) > 0;
    }

    public boolean isTrue(){
        return isShippingCostFree();
    }
}
