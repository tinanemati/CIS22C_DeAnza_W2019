import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * DequequeTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */
class DequeueTest {

	@Test
	void test() {
		Queue q = new Queue();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.dequeue();
		assertEquals("B", q.getFront());
		q.dequeue();
		assertEquals("C", q.getFront());
		q.dequeue();
		assertEquals(0, q.getSize());
	}

}
