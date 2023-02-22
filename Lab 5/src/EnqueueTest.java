import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * EnquequeTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */

class EnqueueTest {

	@Test
	void test() {
			Queue q = new Queue();
			q.enqueue("A");
			assertEquals(false, q.isEmpty());
			q.enqueue("B");
			assertEquals("A", q.getFront());
			q.enqueue("C");
			assertEquals(3, q.getSize());
			
	}

}

