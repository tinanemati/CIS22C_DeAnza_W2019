import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * FindMinTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class FindMinTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		intBst.insert(10);
		intBst.insert(20);
		intBst.insert(6);
		assertEquals(new Integer(6), intBst.findMin());
		intBst.remove(6);
		assertEquals(new Integer(10), intBst.findMin());
		intBst.insert(1);
		assertEquals(new Integer(1), intBst.findMin());
	}

}
