import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * AppendTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */
class AppendTest {

	@Test
	void test() {
		Queue q = new Queue();
		Queue q2 = new Queue();
		q.enqueue("A");
		q.enqueue("B");
		q2.enqueue("C");
		q2.enqueue("D");
		q.append(q2);
		assertEquals("A B C D\n", q.toString());
		q2.append(q);
		assertEquals("C D A B C D\n", q2.toString());
		q.append(q2);
		assertEquals("A B C D C D A B C D\n", q.toString());
	}

}
