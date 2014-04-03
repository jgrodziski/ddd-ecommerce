package ddd.ecommerce.domain;

/**
 * Created by jeremiegrodziski on 03/04/14.
 */
public class ProductId {
    private String value;

    public ProductId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
