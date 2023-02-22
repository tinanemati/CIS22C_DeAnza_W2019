/**
 * BFSTest.java
 * @author Ryan Olivera
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BFSTest {

	@Test
	void test() {
		Graph g = new Graph(7);
		g.addDirectedEdge(1, 3);
		g.addDirectedEdge(1, 4);
		g.addDirectedEdge(1, 5);
		g.addDirectedEdge(2, 6);
		g.addDirectedEdge(3, 5);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(5, 7);
		g.BFS(1);
		assertEquals(new Integer(0), g.getParent(1));
		assertEquals(new Character('B'), g.getColor(5));
		g.BFS(2);
		assertEquals(new Integer(1), g.getDistance(6));
		assertEquals(new Character('W'), g.getColor(1));
		g.BFS(3);
		assertEquals(new Integer(5), g.getParent(7));
		assertEquals(new Integer(-1), g.getDistance(2));
	}

}
