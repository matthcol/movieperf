package util.fwk.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import data.Movie;

public class Tools {

	public static <T> void exploreClass(Class<T> objectClass) {
		System.out.println(objectClass);
		System.out.println("Name :"+objectClass.getName());
		System.out.println("Canonical Name :" +objectClass.getCanonicalName());
		System.out.println("Simple name :" +objectClass.getSimpleName());
		System.out.println("Package :" +objectClass.getPackage());
//		System.out.println(objectClass.getClass());
		System.out.println("Parent class :"+objectClass.getSuperclass());	
		System.out.println("Methods :"+Arrays.toString(objectClass.getMethods()));
		System.out.println("Declared methods :"+Arrays.toString(objectClass.getDeclaredMethods()));
		System.out.println("Methods simplified :"+Arrays.stream(objectClass.getMethods())
				.map(Method::getName)
				.collect(Collectors.joining(", ")));
//				.limit(5)
//				.forEach(System.out::println);
		System.out.println("Getters :"+Arrays.stream(objectClass.getMethods())
				.map(Method::getName)
				.filter(n ->n.matches("(get|is)[A-Z].*") && !n.equals("getClass")) 
				.collect(Collectors.joining(", ")));
		System.out.println("Fields :"+Arrays.toString(objectClass.getFields()));
		System.out.println("Declared fields :"+Arrays.toString(objectClass.getDeclaredFields()));
		
		
	}

	/**
	 * 
	 * @param <T>
	 * @param <U>
	 * @param t
	 * @param fieldName
	 * @param fieldType
	 * @return
	 * @throws ReflectException
	 */
	public static <T,U> U getFieldValue(T t, String fieldName, Class<U> fieldType) 
			throws ReflectException
	{
		Class<?> objectClass =t.getClass();
		//TODO if fieldType is boolean, methodName begins with "is"
		String methodName = "get"+fieldName.substring(0,1).toUpperCase()
				+fieldName.substring(1);
		try {
			Method method = objectClass.getMethod(methodName);
			Class<?> returnType = method.getReturnType();
			//TODO check the compatibility beetween returnType and fieldType
			Object fieldValue = method.invoke(t);
			return fieldType.cast(fieldValue);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			throw new ReflectException("error retrieving field value by reflection",e);
		}
	
	}
	
	

}
