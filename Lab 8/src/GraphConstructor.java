/**
 * GraphConstructorTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GraphConstructor {

	@Test
	void test() {
		Graph g = new Graph(7);
		assertEquals(0, g.getNumEdges());
		Graph g1 = new Graph(2);
		assertEquals(2, g1.getNumVertices());
		Graph g2 = new Graph(0);
		assertEquals(true, g2.isEmpty());
	}

}
