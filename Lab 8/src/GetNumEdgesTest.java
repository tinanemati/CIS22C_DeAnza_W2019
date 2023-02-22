/**
 * GetNumEdgesTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetNumEdgesTest {

	@Test
	void test() {
		Graph g = new Graph(7);
		assertEquals(0, g.getNumEdges());
		g.addDirectedEdge(1, 3);
		g.addDirectedEdge(1, 4);
		g.addDirectedEdge(1, 5);
		assertEquals(3, g.getNumEdges());
		g.addDirectedEdge(2, 6);
		g.addDirectedEdge(3, 5);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(5, 7);
		assertEquals(7, g.getNumEdges());
		
	}

}
