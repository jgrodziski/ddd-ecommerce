package ddd.ecommerce.domain.catalog;

public class VendorId {
    private String value;

    public VendorId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendorId vendorId = (VendorId) o;

        if (value != null ? !value.equals(vendorId.value) : vendorId.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "VendorId{" +
                "value='" + value + '\'' +
                '}';
    }
}
