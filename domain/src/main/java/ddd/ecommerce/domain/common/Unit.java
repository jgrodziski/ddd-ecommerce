package ddd.ecommerce.domain.common;

public class Unit {
	private String code;
	private String symbol;
	
    private Unit(String code, String symbol) {
		super();
		if(code == null && symbol == null){
			throw new RuntimeException("code and symbol must not be null");
		}
		this.code = code;
		this.symbol = symbol;
	}

	public static Unit valueOf(String code, String symbol){
        return new Unit(code, symbol);
    }
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public boolean equals(Object obj){
		if(obj != null && obj instanceof Unit){
			Unit other = (Unit) obj;
			return other.code.equalsIgnoreCase(this.code) && other.symbol.equals(this.symbol);
		}
		return false;
	}
}
