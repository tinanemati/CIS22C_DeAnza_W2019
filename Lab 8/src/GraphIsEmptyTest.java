/**
 * GraphIsEmptyTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GraphIsEmptyTest {

	@Test
	void test() {
		Graph g = new Graph(7);
		assertEquals(false, g.isEmpty());
		Graph g1 = new Graph(0);
		assertEquals(true, g1.isEmpty());
		Graph g2 = new Graph(2);
		assertEquals(false, g2.isEmpty());
	}

}
