import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * AddLastTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
class AddLastTest {

	@Test
	void test() {
		List L = new List();
        L.addLast(1);
        assertEquals(1, L.getLength());
        L.addLast(2);
        assertEquals(2, L.getLast());
        L.addLast(3);
        assertEquals(3, L.getLast());	
	}

}
