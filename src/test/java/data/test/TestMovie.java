package data.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Movie;

class TestMovie {

	@Test
	void testToString() {
		Movie movie = new Movie("Le roi lion", 2018);
		System.out.println(movie);
	}

}
