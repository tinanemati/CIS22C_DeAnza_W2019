import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * RemoveLastTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
class RemoveLastTest {

	@Test
	void test() {
		List L = new List();
		L.addLast(2);
		L.addLast(19);
		L.addLast(10);
		L.removeLast();
		assertEquals(19, L.getLast());
		L.removeLast();
		assertEquals(2, L.getLast());
		L.removeLast();
		assertEquals(0, L.getLength());
	}

}
