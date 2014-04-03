package ddd.ecommerce.domain;

public interface VendorRepository {
    public void store(Vendor vendor);
    public Vendor get(String name);
}
