package util.fwk.reflect.exception;

public class ConstraintMinException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 269163415951643259L;
	
	private final long minValue;
	private final long actualValue;
	public ConstraintMinException(long minValue, long actualValue) {
		super("Minimum constraints violation: "+actualValue+" (actual) < "+minValue+" (minimum)");
		this.minValue = minValue;
		this.actualValue = actualValue;
	}
	public long getMinValue() {
		return minValue;
	}
	public long getActualValue() {
		return actualValue;
	}
	
	

}
