/**
 * GetColorTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetColorTest {

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
		assertEquals(new Character('W'), g.getColor(2));
		g.BFS(1);
		assertEquals(new Character('B'), g.getColor(4));
		assertEquals(new Character('W'), g.getColor(6));
	}

}
