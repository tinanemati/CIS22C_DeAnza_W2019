import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * RemoveTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class RemoveTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		intBst.insert(10);
		intBst.insert(20);
		intBst.insert(28);
		intBst.insert(6);
		intBst.insert(4);
		intBst.remove(10); // hard case
		assertEquals(new Integer(20), intBst.getRoot());
		intBst.remove(28); //easy case
		assertEquals(new Integer(20), intBst.findMax());
		intBst.remove(6); // medium case
		assertEquals(2, intBst.getSize());
	}

}
