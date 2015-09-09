package ddd.ecommerce.domain.marketplace;


import ddd.ecommerce.domain.catalog.Catalog;

import java.util.List;

public class Vendor {
    private VendorId vendorId;
    private String vendorName;
    private List<Catalog> catalogs;

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
