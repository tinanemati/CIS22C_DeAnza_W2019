import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * GetLastTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
class GetLastTest {

	@Test
	void test() {
		List L = new List();
		L.addLast(2);
		assertEquals(2, L.getLast());
		L.addLast(19);
		assertEquals(19, L.getLast());
		L.addLast(10);
		assertEquals(10, L.getLast());
	}

}
