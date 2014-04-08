package ddd.ecommerce.domain.common;

public class Quantity {
    private final Integer value;
    public static final Quantity ONE = new Quantity(1);

    private Quantity(Integer value) {
        if (value < 0) throw new RuntimeException("A quantity is always positive");
        this.value = value;
    }
    public static Quantity valueOf(Integer value){
        if(value == 1) return ONE;
        return new Quantity(value);
    }

    public Integer getValue() {
        return value;
    }

    public boolean lt(Quantity quantity){
        return this.getValue() < quantity.getValue();
    }

    public boolean lte(Quantity quantity){
        return this.getValue() <= quantity.getValue();
    }

    public boolean gt(Quantity quantity){
        return this.getValue() > quantity.getValue();
    }

    public boolean gte(Quantity quantity){
        return this.getValue() >= quantity.getValue();
    }

    public boolean eq(Quantity quantity){
        return this.getValue() == quantity.getValue();
    }

    public Quantity minus(Quantity quantityToRemove) {
        return new Quantity(this.value-quantityToRemove.value);
    }
    public Quantity plus(Quantity quantityToRemove) {
        return new Quantity(this.value+quantityToRemove.value);
    }
}
