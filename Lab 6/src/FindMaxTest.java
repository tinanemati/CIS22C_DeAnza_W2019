import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * FindMaxTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class FindMaxTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		intBst.insert(10);
		intBst.insert(20);
		intBst.insert(6);
		assertEquals(new Integer(20), intBst.findMax());
		intBst.remove(20);
		assertEquals(new Integer(10), intBst.findMax());
		intBst.insert(30);
		assertEquals(new Integer(30), intBst.findMax());
	}

}
