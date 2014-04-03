package ddd.ecommerce.domain.catalog;

/**
 * Created by jeremiegrodziski on 02/04/14.
 */
public class OfferId {
    String offerId;
    public OfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferId() {
        return offerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfferId offerId1 = (OfferId) o;

        if (!offerId.equals(offerId1.offerId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return offerId.hashCode();
    }

    @Override
    public String toString() {
        return "OfferId{" +
                "offerId='" + offerId + '\'' +
                '}';
    }
}
