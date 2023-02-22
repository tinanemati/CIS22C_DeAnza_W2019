/**
 * GetDistanceTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetDistanceTest {

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
		assertEquals(new Integer(-1), g.getDistance(1));
		g.BFS(1);
		assertEquals(new Integer(1), g.getDistance(3));
		assertEquals(new Integer(2), g.getDistance(7));
	}

}
