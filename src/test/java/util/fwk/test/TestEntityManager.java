package util.fwk.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.Movie;
import data.WorkOfArt;
import util.fwk.reflect.EntityManager;
import util.fwk.reflect.exception.PersistenceException;

class TestEntityManager {

	static EntityManager<Movie> movieEntityManager;
	
	@BeforeAll
	static void initEntityManager() {
		movieEntityManager = new EntityManager<>();
	}
	@Test
	void testFindAll() {
		//when
		List<Movie> movies = movieEntityManager.findAll(Movie.class);
		//then
		assertNotNull(movies);
	}

	@Test
	void testFindAllNonPersistentClass() {
		//given
		EntityManager<WorkOfArt> artEntityManager = new EntityManager<>();
		//when + then
		assertThrows(PersistenceException.class, 
				()->artEntityManager.findAll(WorkOfArt.class));
		
	}
}
