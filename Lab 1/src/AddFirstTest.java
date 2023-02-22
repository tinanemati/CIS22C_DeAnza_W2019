import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * AddFirstTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
class AddFirstTest {

	@Test
	void test() {
		List L = new List();
        L.addFirst(1);
        assertEquals(1, L.getLength());
        L.addFirst(2);
        assertEquals(2, L.getFirst());
        L.addFirst(3);
        assertEquals(3, L.getFirst());	
	}

}
