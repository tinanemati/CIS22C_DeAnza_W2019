import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * CopyTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */
class CopyTest {

	@Test
	void test() {
		Queue q = new Queue();
		q.enqueue("A");
		Queue q2 = new Queue(q);
		assertEquals("A\n", q2.toString());
		q.enqueue("B");
		Queue q3 = new Queue(q);
		assertEquals("A B\n", q3.toString());
		Queue q4 = new Queue(q);
		q.dequeue();
		assertEquals(false, q.equals(q4));
	}

}
