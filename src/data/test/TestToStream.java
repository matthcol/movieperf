package data.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import data.Movie;

class TestToStream {
	
	private static List<Movie> movies;
	
	@BeforeAll
	static void initData() {
		movies = new ArrayList<>();
		Collections.addAll(movies, 
				new Movie("Le roi lion", 2018),
				new Movie("film2", 2050, 2),
				new Movie("film3", 1994, 4),
				new Movie("film4", 2018, 2),
				new Movie("film5", 1990, 1),
				new Movie("film6", 2020),
				new Movie("film7", 1999),
				new Movie("film8", 2016, 3),
				new Movie("film9", 2011, 2),
				new Movie("film10", 2018,1));
	}
	@Test
	void testTotalDurationMovie() {
	//.out.println(movies);
	int toatalDuration =	movies.stream()
		.filter(m->m.getAnnee()>2000)
		.mapToInt(m->m.getDuration())
		.sum();
		System.out.println("Durée totale :"+toatalDuration + " h");
	}
	@Test
	void collectFilm2000() {
	//.out.println(movies);
	List<Movie> listMovie = movies.stream()
		.filter(m->m.getAnnee()>2000)
		.collect(Collectors.toList());
		System.out.println(listMovie);
		System.out.println(listMovie.getClass());
	}

	@Test
	void collectFilm2000Beta() {
	//.out.println(movies);
	List<Movie> listMovie = movies.stream()
		.filter(m->m.getAnnee()>2000)
		.collect(Collectors.toCollection(LinkedList::new));
		System.out.println(listMovie);
		System.out.println(listMovie.getClass());
		
	}
	
	@Test
	void collectFilm2000TreeSet() {
	//.out.println(movies);
	SortedSet<Movie> listMovie = movies.stream()
		.filter(m->m.getAnnee()>2000)
		.collect(Collectors.toCollection(()->new TreeSet<>(
				Comparator.comparing(Movie::getAnnee, Comparator.reverseOrder())
				.thenComparing(Movie::getTitle, String::compareToIgnoreCase))));
		System.out.println(listMovie);
		System.out.println(listMovie.getClass());
		
	}
	@Test
	void collectTitleFilm2000TreeSet() {
	//.out.println(movies);
	SortedSet<String> listMovie = movies.stream()
		.filter(m->m.getAnnee()>2000)
		.map(m->m.getTitle())
		.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(listMovie);
		System.out.println(listMovie.getClass());
		
	}
	
	@Test
	void collectFilm2000TreeSetFakeOrder() {
	//.out.println(movies);
	SortedSet<Movie> listMovie = movies.stream()
		.filter(m->m.getAnnee()>2000)
		.collect(Collectors.toCollection(()->new TreeSet<>(
				(m1,m2)->-1)));
		System.out.println(listMovie);
		System.out.println(listMovie.getClass());
		
	}
}
