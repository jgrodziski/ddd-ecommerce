package ddd.ecommerce.domain.catalog;


public class ProductId {
    private String value;

    public ProductId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductId productId = (ProductId) o;

        if (!value.equals(productId.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "ProductId{" +
                "value='" + value + '\'' +
                '}';
    }
}
