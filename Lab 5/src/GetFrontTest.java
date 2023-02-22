import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * GetFrontTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */
class GetFrontTest {

	@Test
	void test() {
		Queue q = new Queue();
		q.enqueue("A");
		assertEquals("A", q.getFront());
		q.enqueue("B");
		assertEquals("A", q.getFront());
		q.dequeue();
		assertEquals("B", q.getFront());
	}

}
