import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * GetRootTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class GetRootTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		intBst.insert(10);
		intBst.insert(20);
		intBst.insert(6);
		assertEquals(new Integer(10), intBst.getRoot());
		intBst.remove(10);
		assertEquals(new Integer(20), intBst.getRoot());
		intBst.remove(20);
		assertEquals(new Integer(6), intBst.getRoot());
	}

}
