import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * IsEmptyTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
class IsEmptyTest {

	@Test
	void test() {
		List L = new List();
        assertEquals(true, L.isEmpty());
        L.addLast(3);
        assertEquals(false, L.isEmpty());
        L.addFirst(2);
        assertEquals(false, L.isEmpty());	
	}

}
