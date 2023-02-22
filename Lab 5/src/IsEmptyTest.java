import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * IsEmptyTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */
class IsEmptyTest {

	@Test
	void test() {
		Queue q = new Queue();
		assertEquals(true, q.isEmpty());
		q.enqueue("A");
		assertEquals(false, q.isEmpty());
		q.dequeue();
		assertEquals(true, q.isEmpty());
	}

}
