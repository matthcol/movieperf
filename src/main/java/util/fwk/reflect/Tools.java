package util.fwk.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

import com.sun.javadoc.ThrowsTag;

import data.Movie;
import util.fwk.reflect.exception.ConstraintMinException;
import util.fwk.reflect.exception.ReflectException;
import util.fwk.reflect.exception.TypeMismatchException;

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
		Arrays.stream(objectClass.getMethods())
				.map(AccessibleObject::getAnnotations)
				.filter(a ->a.length>0)
				.map(Arrays::toString)
				.forEach(System.out::println);
		System.out.println("Getters :"+Arrays.stream(objectClass.getMethods())
				.map(Method::getName)
				.filter(n ->n.matches("(get|is)[A-Z].*") && !n.equals("getClass")) 
				.collect(Collectors.joining(", ")));
		System.out.println("Fields :"+Arrays.toString(objectClass.getFields()));
		
		System.out.println("Declared fields :"+Arrays.toString(objectClass.getDeclaredFields()));
		Arrays.stream(objectClass.getDeclaredFields())
				.map(AccessibleObject::getAnnotations)
				.filter(a ->a.length>0)
				.map(Arrays::toString)
				.forEach(System.out::println);
		
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
	
	public static <T> void minValidation(T t) {
		
		Arrays.stream(t.getClass().getDeclaredFields())
				.filter(f->f.getAnnotation(Min.class)!=null)
				.forEach(f->minFieldValidation(t, f, f.getAnnotation(Min.class)));
	}
	
	/**
	 * 
	 * @param <T>
	 * @param t
	 * @param field
	 * @param minAnnotation
	 * @throws ConstraintMinException
	 * @throws TypeMismatchException
	 */
	public static <T> void minFieldValidation(T t, Field field, Min minAnnotation) 
			throws ConstraintMinException, TypeMismatchException 
	{
		
		long minValue =minAnnotation.value();
		String fieldName= field.getName();
		Class <?> fieldType = field.getType();
		System.out.println(minValue+", " +fieldName+", " + fieldType);
		// TODO : en fonction du type du field
		if(fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
			int fieldValue = getFieldValue(t,fieldName,Integer.class);
			System.out.println("fieldValue :"+fieldValue);
			System.out.println("minValue :"+minValue);
			if (fieldValue<minValue)
				throw new ConstraintMinException(minValue, fieldValue);
				
		} else if(fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
			long fieldValue = getFieldValue(t,fieldName,Long.class);
			if (fieldValue<minValue)
				throw new ConstraintMinException(minValue, fieldValue);			
		}else {
			throw new TypeMismatchException(long.class, fieldType);
		}
	}
	
	

}
