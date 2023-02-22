/**
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 4
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsSortedTest {

	@Test
	void test() {
		List<Integer> test = new List<Integer>();
		assertEquals(true, test.isSorted());
		for(int i = 1; i < 6; i++) {
			test.addLast(i);
		}
		assertEquals(true, test.isSorted());
		test.addLast(0);
		assertEquals(false, test.isSorted());
	}

}
