import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * GetHeightTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class GetHeightTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		assertEquals(-1, intBst.getHeight());
		intBst.insert(10);
		assertEquals(0, intBst.getHeight());
		intBst.insert(20);
		intBst.insert(13);
		intBst.insert(28);
		intBst.insert(4);
		assertEquals(2, intBst.getHeight());
	}

}
