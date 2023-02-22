/**
 * GraphTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

public class GraphTest {
	public static void main(String[] args) {
		System.out.println("***Testing Constructor***\n");
		System.out.println("Creating graph g with 2 vertices and 0 edges...\n");
		Graph g = new Graph(2);
		System.out.println("Number of vertices in graph g; Should print 2: " +  g.getNumVertices() + "\n");
		System.out.println("Number of edges in graph g; Should print 0: " + g.getNumEdges() + "\n");
		System.out.println("Creating graph g1 with 3 vertices and 0 edges...\n");
		Graph g1 = new Graph(3);
		System.out.println("Color of vertex 1 in graph g1; Should print W: " + g1.getColor(1) + "\n");
		System.out.println("Parent of vertex 1 in graph g1; Should print 0: " + g1.getParent(1));
		System.out.println("\n\n***Testing getNumEdges***\n");
		System.out.println("Adding an undirected edge from vertex 1 to 2 in graph g...\n");
		g.addUndirectedEdge(1, 2);
		System.out.println("Should print 1: " + g.getNumEdges());
		System.out.println("\nAdding directed edge from 1 to 3, 3 to 2, and 2 to 1 in graph g1...");
		g1.addDirectedEdge(1, 3);
		g1.addDirectedEdge(3, 2);
		g1.addDirectedEdge(2, 1);
		System.out.println("\nNumber of edges in graph g1; Should print 3: " + g1.getNumEdges());
		System.out.println("\n\n***Testing getNumVertices***\n");
		System.out.println("Number of vertices in graph g1; Should print 3: " +  g1.getNumVertices());
		System.out.println("\nCreating graph g2 with 0 vertices and edges...");
		Graph g2 = new Graph(0);
		System.out.println("\nNumber of vertices in graph g2; Should print 0: " +  g2.getNumVertices());
		System.out.println("\n\n***Testing isEmpty***\n");
		System.out.println("Whether g2 is empty or not; Should print true: " + g2.isEmpty());
		System.out.println("\nWhether g is empty or not; Should print false: " + g.isEmpty());
		System.out.println("\n\n***Testing addDirectedEdge***\n");
		System.out.println("Creating graph g3 with 4 vertices and 0 edges...");
		Graph g3 = new Graph(4);
		System.out.println("\nAdding directed edge from 1 to 2, 2 to 4, and 3 to 2...");
		g3.addDirectedEdge(1, 2);
		g3.addDirectedEdge(2, 4);
		g3.addDirectedEdge(3, 2);
		System.out.println("\nNumber of edges in g3; Should print 3: " + g3.getNumEdges());
		System.out.println("\nAdjacency list in g3; Should print: \n1: 2\n2: 4\n3: 2\n4: ");
		System.out.println("----------");
		System.out.println(g3.toString());
		System.out.println("\n**Testing addUndirectedEdge***\n");
		System.out.println("Creating the graph g4 with 5 vertices and 0 edges...");
		Graph g4 = new Graph(5);
		System.out.println("\nAdding the undirected edges from 1 to 2, 1 to 5, 2 to 3, 3 to 4, 4 to 2, and 4 to 5...");
		g4.addUndirectedEdge(1, 2);
		g4.addUndirectedEdge(1, 5);
		g4.addUndirectedEdge(2, 3);
		g4.addUndirectedEdge(4, 2);
		g4.addUndirectedEdge(4, 3);
		g4.addUndirectedEdge(4, 5);	
		System.out.println("\nNumber of edges in g4; Should print 6: " + g4.getNumEdges());
		System.out.println("\nAdjacency list in g4; Should print: \n1: 2 5\n2: 1 3 4\n3: 2 4\n4: 2 3 5\n5: 1 4");
		System.out.println("------------");
		System.out.println(g4.toString());
		System.out.println("\n***Testing BFS and printBFS***\n");
		System.out.println("Tracing graph g4 with the source vertex 1: ");
		g4.BFS(1);
		g4.printBFS();
		System.out.println("\nTracing graph g3 with the source vertex 2: ");
		g3.BFS(2);
		g3.printBFS();
		System.out.println("\n***Testing DFS and printDFS***\n");
		Graph g5 = new Graph(5);
		g5.addUndirectedEdge(1, 2);
		g5.addUndirectedEdge(1, 3);
		g5.addUndirectedEdge(1, 5);
		g5.addUndirectedEdge(2, 3);
		g5.addUndirectedEdge(2, 4);
		g5.addUndirectedEdge(3, 4);
		g5.addUndirectedEdge(4, 5);
		g5.DFS();
		g5.printDFS();
		System.out.println("\n\n***Testing printAllPath***\n");
		System.out.println("\n\n***Testing printPath***\n");
		System.out.println("Shortest path from 1 to 4 in graph g4(1 2 4): " + g4.printPath(1, 4, " "));
		System.out.println("\nShortest path from 2 to 2 in graph g3(2 2): " + g3.printPath(2, 2, " "));
		System.out.println("\nShortest path from 2 to 3 in graph g(DNE): " + g3.printPath(2, 3, " "));
		System.out.println("\n\n***Testing getParent***\n");
		System.out.println("Should print 2 for parent of 4 in graph g4: " + g4.getParent(4));
		System.out.println("\nShould print 0 for parent of 2 in graph g3: " + g3.getParent(2));
		System.out.println("\n\n***Testing getColor***\n");
		System.out.println("Should print B for color of 2 in graph g4: " + g4.getColor(2));
		System.out.println("\nShould print W for color of 1 in graph g3: " + g3.getColor(1));
		System.out.println("\n\n***Testing getDistance***\n");
		System.out.println("Should print 1 for distance of 5 from the source 1 in graph g4: " + g4.getDistance(5));
		System.out.println("\nShould print 0 for distance of 1 from the source 1 in graph g4: " + g4.getDistance(1));
		System.out.println("\n\n***Testing toString***\n");
		System.out.println("Printing Graph g adjacency list vertices: \n" + g.toString());
		System.out.println("Printing Graph g1 adjacency list vertices: \n" + g1.toString());
		
		
		
		
		System.out.println("\n***Testing Error Messages***\n");
		try {
			System.out.println("Error for getDistance. Vertex is not in the graph.");
			g.getDistance(3);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for getParent. Vertex is not in the graph.");
			g.getParent(3);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for getColor. Vertex is not in the graph.");
			g.getColor(-1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for addDirectedEdge. Vertex is not in the graph.");
			g.addDirectedEdge(1, 4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for addDirectedEdge. Vertex cannot be less than zero.");
			g.addDirectedEdge(-1, 2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for addUndirectedEdge. Vertex is not in the graph.");
			g.addUndirectedEdge(1, 4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for addUndirectedEdge. Vertex cannot be less than zero.");
			g.addUndirectedEdge(-1, 2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for BFS. Source is not in the graph.");
			g.BFS(4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\nError for BFS. Graph is empty.");
			g2.BFS(1);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}
/*
***Testing Constructor***

Creating graph g with 2 vertices and 0 edges...

Number of vertices in graph g; Should print 2: 2

Number of edges in graph g; Should print 0: 0

Creating graph g1 with 3 vertices and 0 edges...

Color of vertex 1 in graph g1; Should print W: W

Parent of vertex 1 in graph g1; Should print 0: 0


***Testing getNumEdges***

Adding an undirected edge from vertex 1 to 2 in graph g...

Should print 1: 1

Adding directed edge from 1 to 3, 3 to 2, and 2 to 1 in graph g1...

Number of edges in graph g1; Should print 3: 3


***Testing getNumVertices***

Number of vertices in graph g1; Should print 3: 3

Creating graph g2 with 0 vertices and edges...

Number of vertices in graph g2; Should print 0: 0


***Testing isEmpty***

Whether g2 is empty or not; Should print true: true

Whether g is empty or not; Should print false: false


***Testing addDirectedEdge***

Creating graph g3 with 4 vertices and 0 edges...

Adding directed edge from 1 to 2, 2 to 4, and 3 to 2...

Number of edges in g3; Should print 3: 3

Adjacency list in g3; Should print: 
1: 2
2: 4
3: 2
4: 
---------
1: 2 
2: 4 
3: 2 
4: 


**Testing addUndirectedEdge***

Creating the graph g4 with 5 vertices and 0 edges...

Adding the undirected edges from 1 to 2, 1 to 5, 2 to 3, 3 to 4, 4 to 2, and 4 to 5...

Number of edges in g4; Should print 6: 6

Adjacency list in g4; Should print: 
1: 2 5
2: 1 3 4
3: 2 4
4: 2 3 5
5: 1 4
------------
1: 2 5 
2: 1 3 4 
3: 2 4 
4: 2 3 5 
5: 1 4 


***Testing BFS and printBFS***

Tracing graph g4 with the source vertex 1: 
v	c	p	d
1	B	0	0
2	B	1	1
3	B	2	2
4	B	2	2
5	B	1	1

Tracing graph g3 with the source vertex 2: 
v	c	p	d
1	W	0	-1
2	B	0	0
3	W	0	-1
4	B	2	1


***Testing printPath***

Shortest path from 1 to 4 in graph g4(1 2 4): 1 2 4  

Shortest path from 2 to 2 in graph g3(2 2): 2  

Shortest path from 2 to 3 in graph g(DNE): 
No path from 2 to 3 exists


***Testing getParent***

Should print 2 for parent of 4 in graph g4: 2

Should print 0 for parent of 2 in graph g3: 0


***Testing getColor***

Should print B for color of 2 in graph g4: B

Should print W for color of 1 in graph g3: W


***Testing getDistance***

Should print 1 for distance of 5 from the source 1 in graph g4: 1

Should print 0 for distance of 1 from the source 1 in graph g4: 0


***Testing toString***

Printing Graph g adjacency list vertices: 
1: 2 
2: 1 

Printing Graph g1 adjacency list vertices: 
1: 3 
2: 1 
3: 2 


***Testing Error Messages***

Error for getDistance. Vertex is not in the graph.
getDistance(): vertex 3 is not in the graph. Cannot get distance.

Error for getParent. Vertex is not in the graph.
getParent(): vertex 3 is not in the graph. Cannot get parent.

Error for getColor. Vertex is not in the graph.
getColor(): vertex -1 is not in the graph. Cannot get color.

Error for addDirectedEdge. Vertex is not in the graph.
addDirectedEdge(): vertex is not in the graph.

Error for addDirectedEdge. Vertex cannot be less than zero.
addDirectedEdge(): u cannot be less than 0.

Error for addUndirectedEdge. Vertex is not in the graph.
addDirectedEdge(): vertex is not in the graph.

Error for addUndirectedEdge. Vertex cannot be less than zero.
addDirectedEdge(): vertex cannot be less than 0.

Error for BFS. Source is not in the graph.
BFS(): 4 is not in the graph. Cannot perform breath first search.

Error for BFS. Graph is empty.
BFS(): Graph is empty. Cannot perform breath first search.
*/