/**
 * PrintPathTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrintPathTest {

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
		assertEquals("1 5 7 ", g.printPath(1, 7, ""));
		g.BFS(2);
		assertEquals("2 6 ", g.printPath(2, 6, ""));
		g.BFS(3);
		assertEquals("3 ", g.printPath(3, 3, ""));
	}

}
