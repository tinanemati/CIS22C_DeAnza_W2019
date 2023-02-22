import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * SearchTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class SearchTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		intBst.insert(10);
		intBst.insert(20);
		intBst.insert(6);
		assertEquals(true, intBst.search(20));
		assertEquals(true, intBst.search(6));
		assertEquals(false, intBst.search(1));
	}

}
