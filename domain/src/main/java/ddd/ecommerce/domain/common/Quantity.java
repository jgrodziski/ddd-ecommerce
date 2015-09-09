package ddd.ecommerce.domain.common;

import java.util.concurrent.Callable;

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
    	return this.checkAndExecute(new Callable<Boolean>() {
    		public Boolean call() throws Exception{
    			return Quantity.this.getValue() < quantity.getValue();
    		}
		}, quantity);
    }

    public boolean lte(final Quantity quantity){
        return this.checkAndExecute(new Callable<Boolean>() {
    		public Boolean call() throws Exception{
    			return Quantity.this.getValue() <= quantity.getValue();
    		}
		}, quantity);
    }

    public boolean gt(final Quantity quantity){
        return this.checkAndExecute(new Callable<Boolean>() {
    		public Boolean call() throws Exception{
    			return Quantity.this.getValue() > quantity.getValue();
    		}
		}, quantity);
    }

    public boolean gte(final Quantity quantity){
        return this.checkAndExecute(new Callable<Boolean>() {
    		public Boolean call() throws Exception{
    			return Quantity.this.getValue() >= quantity.getValue();
    		}
		}, quantity);
    }

    public boolean eq(final Quantity quantity){
    	return this.checkAndExecute(new Callable<Boolean>() {
    		public Boolean call() throws Exception{
    			return Quantity.this.getValue() == quantity.getValue();
    		}
		}, quantity);
    }

    public Quantity minus(final Quantity quantityToRemove) {
    	return this.checkAndExecute(new Callable<Quantity>() {
    		public Quantity call() throws Exception{
    			return new Quantity(Quantity.this.value-quantityToRemove.value, Quantity.this.unit);
    		}
		}, quantityToRemove);
    }
    
    public Quantity plus(final Quantity quantityToAdd) {
    	return this.checkAndExecute(new Callable<Quantity>() {
    		public Quantity call() throws Exception{
    			return new Quantity(Quantity.this.value+quantityToAdd.value, Quantity.this.unit);
    		}
		}, quantityToAdd);
    }
    
    private <T> T checkAndExecute(Callable<T> callable, Quantity otherQuantity){
    	if(this.unit.equals(otherQuantity)){
    		try {
				return callable.call();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
    	}
    	throw new RuntimeException("The unit is not compatible");
    }
}
