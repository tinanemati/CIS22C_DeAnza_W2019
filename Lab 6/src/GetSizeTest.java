import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * GetSizeTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class GetSizeTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		assertEquals(0, intBst.getSize());
		intBst.insert(10);
		assertEquals(1, intBst.getSize());
		intBst.insert(-10);
		assertEquals(2, intBst.getSize());
	}

}
