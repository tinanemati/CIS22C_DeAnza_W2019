import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * CopyTest.java
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 6
 */
class CopyTest {

	@Test
	void test() {
		BST<Integer> intBst = new BST<Integer>();
		intBst.insert(10);
		intBst.insert(22);
		BST<Integer> intBstCopy = new BST<Integer>(intBst); // Testing general case
		assertEquals(true, intBst.equals(intBstCopy));
		intBstCopy.remove(22); 
		assertEquals(false, intBst.equals(intBstCopy));// Testing deep copy
		BST<Character> charBst = new BST<Character>();
		BST<Character> charBstCopy = new BST<Character>(charBst);
		assertEquals(true, charBst.equals(charBstCopy)); // Testing edge case
	}

}
