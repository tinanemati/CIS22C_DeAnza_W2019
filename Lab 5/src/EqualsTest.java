import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * EqualsTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */
class EqualsTest {

	@Test
	void test() {
		Queue q = new Queue();
		Queue q2 = new Queue();
		q.enqueue("A");
		assertEquals(false, q.equals(q2));
		q2.enqueue("A");
		assertEquals(true, q.equals(q2));
		q.dequeue();
		assertEquals(false, q.equals(q2));
	}

}
