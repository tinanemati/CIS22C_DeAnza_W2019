/** 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 4
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetIndexTest {

	@Test
	void test() {
		List<Integer> test = new List<Integer>();
		for (int i = 1; i < 6; i++) {
			test.addLast(i);
		}
		test.pointIterator();
		assertEquals(1, test.getIndex());
		test.advanceIterator();
		assertEquals(2, test.getIndex());
		test.moveToIndex(5);
		assertEquals(5, test.getIndex());
	}

}
