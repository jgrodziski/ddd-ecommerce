package ddd.ecommerce.domain.payment;

public class CreditCardNumber {
    private String creditCardNumber;

    public CreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}
