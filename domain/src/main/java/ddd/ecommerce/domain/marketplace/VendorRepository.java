package ddd.ecommerce.domain.marketplace;

public interface VendorRepository {
    public void store(Vendor vendor);
    public Vendor get(VendorId vendorId);
}
