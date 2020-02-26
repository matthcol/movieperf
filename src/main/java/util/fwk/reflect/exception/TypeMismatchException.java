package util.fwk.reflect.exception;

public class TypeMismatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5608742394879254024L;
	private final Class<?> expectedType;
	private final Class<?> actualType;
	public TypeMismatchException(Class<?> expectedType, Class<?> actualType) {
		super("Type mismatch: "+actualType+" (actual), "+expectedType+" (expected)");

		this.expectedType = expectedType;
		this.actualType = actualType;
	}
	public Class<?> getExpectedType() {
		return expectedType;
	}
	public Class<?> getActualType() {
		return actualType;
	}
	
}
