package util.fwk.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.HororMovie;
import data.Movie;
import util.fwk.FwkInput3;

class TestFwkInout3 {

	@Test
	void test() {
		List<String> titles = new ArrayList<>();
		Collections.addAll(titles, "Joker","Parasite", "The dark knight");
		
		Deque<Integer> years = new LinkedList<>();
		Collections.addAll(years, 2019,2019, 2008);
		
		Deque<Integer> durations = new LinkedList<>();
		Collections.addAll(durations, 165,132,152);
		
		List<Movie> movies = FwkInput3.doSomething(titles, years, durations, Movie::new, ArrayList::new);
		System.out.println(movies);
		
		
	}

	
	@Test
	void testHeritage() {
		List<String> titles = new ArrayList<>();
		Collections.addAll(titles, "Joker","Parasite", "The dark knight");
		
		Deque<Integer> years = new LinkedList<>();
		Collections.addAll(years, 2019,2019, 2008);
		
		Deque<Integer> durations = new LinkedList<>();
		Collections.addAll(durations, 165,132,152);
		
		List<Movie> movies = FwkInput3.doSomething(titles, years, durations, 
				(t,y,d)->new HororMovie(t,y,d,2.343), ArrayList::new);
		System.out.println(movies);
		
		
	}

}
