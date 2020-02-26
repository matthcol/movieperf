package util.fwk.reflect;

import java.lang.annotation.Annotation;
import java.util.Optional;

public class Annotations {
	
	public static <A extends Annotation> Optional<A>  getAnnotation(Class<?> clazz, Class<A> annotationClass) {
		A a = clazz.getAnnotation(annotationClass);
		return Optional.ofNullable(a);
		
	}

}
