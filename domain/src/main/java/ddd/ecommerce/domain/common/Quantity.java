package ddd.ecommerce.domain.common;

public class Quantity {
    private final Integer value;
    private final Unit unit;

    private Quantity(Integer value, Unit unit) {
        if (value < 0) throw new RuntimeException("A quantity is always positive");
        if (unit == null) throw new RuntimeException("The unit cannot be null");
        this.value = value;
        this.unit = unit;
    }
    public static Quantity valueOf(Integer value, Unit unit){
        return new Quantity(value, unit);
    }

    public Integer getValue() {
        return value;
    }

    public Unit getUnit() {
		return unit;
	}
    
	public boolean lt(final Quantity quantity){
		checkUnitCompatibility(quantity);
    	return Quantity.this.getValue() < quantity.getValue();
    }

    public boolean lte(final Quantity quantity){
    	checkUnitCompatibility(quantity);
    	return Quantity.this.getValue() <= quantity.getValue();
    }

    public boolean gt(final Quantity quantity){
    	checkUnitCompatibility(quantity);
    	return Quantity.this.getValue() > quantity.getValue();
    }

    public boolean gte(final Quantity quantity){
    	checkUnitCompatibility(quantity);
    	return Quantity.this.getValue() >= quantity.getValue();
    }

    public boolean eq(final Quantity quantity){
    	checkUnitCompatibility(quantity);
    	return Quantity.this.getValue() == quantity.getValue();
    }

    public Quantity minus(final Quantity quantityToRemove) {
    	checkUnitCompatibility(quantityToRemove);
    	return new Quantity(Quantity.this.value-quantityToRemove.value, Quantity.this.unit);
    }
    
    public Quantity plus(final Quantity quantityToAdd) {
    	checkUnitCompatibility(quantityToAdd);
    	return new Quantity(Quantity.this.value+quantityToAdd.value, Quantity.this.unit);
    }
    
    private void checkUnitCompatibility(Quantity otherQuantity){
    	if(!this.unit.equals(otherQuantity.unit)){    		
    		throw new RuntimeException("The unit is not compatible");
    	}
    }
}
