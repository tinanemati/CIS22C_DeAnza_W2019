import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * GetSizeTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */
class GetSizeTest {

	@Test
	void test() {
		Queue q = new Queue();
		assertEquals(0, q.getSize());
		q.enqueue("A");
		assertEquals(1, q.getSize());
		q.enqueue("B");
		assertEquals(2, q.getSize());

	}

}
