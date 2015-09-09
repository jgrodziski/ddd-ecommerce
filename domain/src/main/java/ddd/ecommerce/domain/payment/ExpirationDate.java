package ddd.ecommerce.domain.payment;

/**
 * Created by jeremiegrodziski on 14/01/15.
 */
public class ExpirationDate {
    private String expirationDate;

    public ExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
