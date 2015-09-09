package ddd.ecommerce.domain.common;


public interface AmountCalculator extends Rule<Amount> {

    public Amount calculate();

}
