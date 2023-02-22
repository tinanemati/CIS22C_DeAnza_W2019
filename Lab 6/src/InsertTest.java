import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * InsertTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class InsertTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		intBst.insert(10);
		assertEquals(new Integer(10), intBst.getRoot());
		intBst.insert(20);
		assertEquals(new Integer(20), intBst.findMax());
		assertEquals(new Integer(10), intBst.getRoot());
		intBst.insert(6);
		assertEquals(new Integer(6), intBst.findMin());
	}

}
