import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * EqualsTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class EqualsTest {

	@Test
	void test() {
		BST<Integer> intBst1 = new BST<Integer>();
		BST<Integer> intBst2 = new BST<Integer>();
		assertEquals(true, intBst1.equals(intBst2));
		intBst1.insert(10);
		intBst1.insert(22);
	    intBst1.insert(12);
		assertEquals(false, intBst1.equals(intBst2));
		intBst2.insert(10);
		intBst2.insert(22);
	    intBst2.insert(12);
		assertEquals(true, intBst1.equals(intBst2));
		intBst1.remove(10);
		assertEquals(false, intBst1.equals(intBst2));
	}

}
