package ddd.ecommerce.domain.common;

/**
 * Created by jeremiegrodziski on 02/04/14.
 */
public class Quantity {
    Integer value;
    public static final Quantity ONE = new Quantity(1);

    public Quantity(Integer value) {
        if (value < 1) throw new RuntimeException("A quantity is always positive");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
