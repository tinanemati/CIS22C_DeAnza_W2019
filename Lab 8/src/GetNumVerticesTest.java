/**
 * GetNumVerticesTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetNumVerticesTest {

	@Test
	void test() {
		Graph g = new Graph(7);
		assertEquals(7, g.getNumVertices());
		g.addDirectedEdge(1, 3);
		g.addDirectedEdge(1, 4);
		g.addDirectedEdge(1, 5);
		assertEquals(7, g.getNumVertices()); // should still be 7 
		Graph g1 = new Graph(0);
		assertEquals(0, g1.getNumVertices());
	}

}
