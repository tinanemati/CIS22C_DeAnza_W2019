import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * RemoveFirstTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
class RemoveFirstTest {

	@Test
	void test() {
		List L = new List();
		L.addFirst(2);
		L.addFirst(19);
		L.addFirst(10);
		L.removeFirst();
		assertEquals(19, L.getFirst());
		L.removeFirst();
		assertEquals(2, L.getFirst());
		L.removeFirst();
		assertEquals(0, L.getLength());
		
	}

}
