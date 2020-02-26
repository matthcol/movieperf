package concurrent.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class TestForJoinPool {

	@Test
	void test() {
		ForkJoinPool pool = new ForkJoinPool(3);
		//lancement des taches en parallele
		var r1 = pool.submit(() -> compute(4));
		ForkJoinTask<Integer> r2 = pool.submit(() -> compute(5));
		var r3 = pool.submit(() -> compute(6));
		var r4 = pool.submit(() -> compute(7));
		//recupération des données avec synchronisation
		System.out.println(r1.join());
		System.out.println(r2.join());
		System.out.println(r3.join());
		System.out.println(r4.join());
		pool.shutdown();
		
	}

	static int compute(int x) {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 3+x;
	}
}
