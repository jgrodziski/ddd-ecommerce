package ddd.ecommerce.domain.customer;

/**
 * Created by jeremiegrodziski on 02/04/14.
 */
public class BuyerId {
    String value;

    public BuyerId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
