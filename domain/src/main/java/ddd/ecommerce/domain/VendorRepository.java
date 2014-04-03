package ddd.ecommerce.domain;

import ddd.ecommerce.domain.catalog.VendorId;

public interface VendorRepository {
    public void store(Vendor vendor);
    public Vendor get(VendorId vendorId);
}
