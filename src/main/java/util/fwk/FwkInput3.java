package util.fwk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

import util.function.TriFunction;

public class FwkInput3 {

	public static <T,U,V,R,C extends Collection<R>> C doSomething(
			Collection<? extends T> ct, Collection<? extends U> cu, Collection<? extends V> cv, 
			TriFunction<? super T, ? super U, ? super V, ? extends R> f,
			Supplier<C> collectionFactory) 
	{
		C cr = collectionFactory.get();
		for(T t:ct) {
			for(U u: cu) {
				for(V v: cv) {
					R r = f.apply(t, u, v);
					cr.add(r);
				}
			}
		}
		return cr;
	}


}
