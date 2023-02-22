import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * HashMethodTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 7
 */

class HashMethodTest {

	@Test
	void test() {
		Hash<Integer> t = new Hash<Integer>(20);
		assertEquals(0, t.getNumElements());
		Hash<Movie> m = new Hash<Movie>(8);
		assertEquals(0, m.getNumElements());
		Hash<String> s = new Hash<String>(10);
		assertEquals(0, s.getNumElements());
	}

}
