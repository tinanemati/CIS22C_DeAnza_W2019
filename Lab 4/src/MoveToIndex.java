/**
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 4
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoveToIndex {

	@Test
	void test() {
		List<Integer> test = new List<Integer>();
		for (int i = 1; i < 6; i++) {
			test.addLast(i);
		}
		test.moveToIndex(4);
		assertEquals(4, test.getIndex());
		test.moveToIndex(1);
		assertEquals(1, test.getIndex());
		test.moveToIndex(5);
		assertEquals(5, test.getIndex());
	}

}
