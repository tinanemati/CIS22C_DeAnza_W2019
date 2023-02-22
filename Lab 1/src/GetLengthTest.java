import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * GetLengthTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
class GetLengthTest {

	@Test
	void test() {
		List L = new List();
        assertEquals(0, L.getLength());
        L.addLast(3);
        assertEquals(1, L.getLength());
        L.addFirst(2);
        assertEquals(2, L.getLength());
	}

}
