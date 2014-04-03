package ddd.ecommerce.domain.customer;

import ddd.ecommerce.domain.common.Amount;
import ddd.ecommerce.domain.common.BooleanRule;

/**
 * When <basket balance > a minimum amount>
 * Then delivery costs are 0
 */
public class FreeShippingCostRule implements BooleanRule {
    private Amount basketBalance;
    private Amount minimumBalanceForFreeShippingCost;

    public FreeShippingCostRule(Amount basketBalance, Amount minimumBalanceForFreeShippingCost) {
        this.basketBalance = basketBalance;
        this.minimumBalanceForFreeShippingCost = minimumBalanceForFreeShippingCost;
    }

    public boolean isShippingCostFree(){
        return basketBalance.getValue().compareTo(minimumBalanceForFreeShippingCost.getValue()) > 0;
    }

    public boolean isTrue(){
        return isShippingCostFree();
    }
}
