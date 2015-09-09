package ddd.ecommerce.domain.payment;


public class CreditCardInfo {
    public CreditCardNumber creditCardNumber;
    public ExpirationDate expirationDate;
    public SecurityNumber CVCSecurityNumber;
    public CardHolderName cardHolderName;

    public CreditCardInfo(String creditCardNumber, String cvc, String expirationDate) {
        this.creditCardNumber = new CreditCardNumber(creditCardNumber);
        this.expirationDate = new ExpirationDate(expirationDate);
        this.CVCSecurityNumber = new SecurityNumber(cvc);
    }
}
