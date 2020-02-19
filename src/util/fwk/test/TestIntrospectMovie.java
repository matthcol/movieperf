package util.fwk.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import org.junit.jupiter.api.Test;

import data.Movie;
import util.fwk.reflect.Tools;

class TestIntrospectMovie {

	@Test
	void testMovie() {
		Movie m = new Movie("Le roi lion", 1994, 88);
		Class<?> objectClass = m.getClass();
		Tools.exploreClass(objectClass);
	}
	
	@Test
	void testPrimitif() {
		Class<?> primitifClass = int.class;
		Tools.exploreClass(primitifClass);
	}
	
	@Test
	void testPrimitifBoxed() {
		Class<?> primitifClass = Integer.class;
		Tools.exploreClass(primitifClass);
	}
	
	@Test
	void testAnnotation() {
		Class<?> objectClass = Override.class;
		Tools.exploreClass(objectClass);
	}
	
	@Test
	void testInterface() {
		Class<?> objectClass = List.class;
		Tools.exploreClass(objectClass);
		
	}
	
	@Test
	void testNewInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		//given
		Class<Movie> objectClass = Movie.class;
		String setterName = "setTitle";
		String fieldValue = "Le roi lion";
		Class<String> fieldType = String.class;
		
		//when
		Movie object = objectClass.getDeclaredConstructor().newInstance();
		Method method = objectClass.getMethod(setterName, fieldType);
		method.invoke(object, fieldValue);
		
		//then
		assertEquals(fieldValue, object.getTitle());
		
	}
	
}
