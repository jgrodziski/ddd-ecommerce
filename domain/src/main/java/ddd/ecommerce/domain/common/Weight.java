package ddd.ecommerce.domain.common;


import java.math.BigDecimal;

public class Weight {
    public BigDecimal weight;
    public WeightUnit unit;

    public Weight(BigDecimal weight) {
        this.weight = weight;
        this.unit = WeightUnit.KG;
    }

    public Weight(BigDecimal weight, WeightUnit unit) {
        this.weight = weight;
        this.unit = unit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public WeightUnit getUnit() {
        return unit;
    }
}
