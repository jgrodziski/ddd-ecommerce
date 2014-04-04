package ddd.ecommerce.domain;

import ddd.ecommerce.domain.catalog.VendorId;


public class Vendor {
    private VendorId vendorId;
    private String vendorName;

    public Vendor(VendorId vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

    public VendorId getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }
}
