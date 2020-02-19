package util.fwk.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Movie;
import util.fwk.reflect.Tools;

class TestTools {

	@Test
	void testGetFieldvalueObject() {
		
		//given
		String title = "Le roi lion";
		Movie m = new Movie(title, 1994, 88);
		String fieldName = "title";
		Class<String> fieldType = String.class;
		//When
		String fieldValue = Tools.getFieldValue(m,fieldName, fieldType);
		//then
		assertEquals(title, fieldValue);
	}

	@Test
	void testGetFieldvaluePrimitive() {
		
		//given
		int duration = 88;
		Movie m = new Movie("Le roi lion", 1994, duration);
		String fieldName = "duration";
		Class<Integer> fieldType = Integer.class;
		//When
		int fieldValue = Tools.getFieldValue(m,fieldName, fieldType);
		//then
		assertEquals(duration, fieldValue);
	}

}
