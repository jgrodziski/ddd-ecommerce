package ddd.ecommerce.domain;

/**
 * Created by jeremiegrodziski on 03/04/14.
 */
public class Vendor {
    private String vendorId;
    private String vendorName;

    public Vendor(String vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }
}
