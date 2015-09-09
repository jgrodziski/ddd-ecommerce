package ddd.ecommerce.domain.catalog;

import ddd.ecommerce.domain.common.Amount;

public class CartEntryPrice {

    private final Amount amount;

    private final Amount discountAmount;

    public CartEntryPrice(Amount amount, Amount discountValue) {
        this.amount = amount;
        this.discountAmount = discountValue;
    }

    public CartEntryPrice add(CartEntryPrice other) {
        return new CartEntryPrice(amount.add(other.getAmount()), discountAmount.add(other.getDiscountAmount()));
    }

    public Amount getAmountWithDiscouts() {
        return amount.subtract(discountAmount);
    }

    public Amount getDiscountAmount() {
        return discountAmount;
    }

    public Amount getAmount() {
        return amount;
    }
}
