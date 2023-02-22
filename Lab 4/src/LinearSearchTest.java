/**
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 4
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinearSearchTest {

	@Test
	void test() {
		List<Integer> test = new List<Integer>();
		for(int i = 1; i < 6; i++) {
			test.addLast(i);
		}
		assertEquals(3, test.linearSearch(3));
		assertEquals(-1, test.linearSearch(0));
		assertEquals(4, test.linearSearch(4));
	}

}
