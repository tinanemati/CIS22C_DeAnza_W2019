/**
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 4
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void test() {
		List<Integer> test = new List<Integer>();
		for(int i = 1; i < 6; i++) {
			test.addLast(i);
		}
		assertEquals(-1, test.binarySearch(0));
		assertEquals(1, test.binarySearch(1));
		assertEquals(5, test.binarySearch(5));
	}

}
