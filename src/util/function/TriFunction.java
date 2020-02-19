package util.function;

import java.util.Collection;

@FunctionalInterface
public interface TriFunction <T,U,V,R> {
	
	R apply (T t, U cu, V v);

}
