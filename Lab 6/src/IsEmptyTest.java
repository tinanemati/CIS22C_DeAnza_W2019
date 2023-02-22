import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * IsEmptyTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class IsEmptyTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		assertEquals(true, intBst.isEmpty());
		intBst.insert(10);
		assertEquals(false, intBst.isEmpty());
		intBst.remove(10);
		assertEquals(true, intBst.isEmpty());
	}
}
