/**
 * Graph.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 8
 */

import java.util.ArrayList;

public class Graph {
    private int vertices;
    private int edges; 
    private int time;
    private ArrayList<List<Integer> > adj;
    private ArrayList<Character> color;
    private ArrayList<Integer> distance;
    private ArrayList<Integer> parent;
    private ArrayList<Integer> discovery_time;
    private ArrayList<Integer> finish_time;
    
    /**Constructors*/

  /**
   * initializes an empty graph, with n vertices
   * and 0 edges
   * @param n the number of vertices in the graph
   */
    public Graph(int n) {
    	adj = new ArrayList<List<Integer>>();
    	color = new ArrayList<Character>();
    	distance = new ArrayList<Integer>();
    	parent = new ArrayList<Integer>();
    	discovery_time = new ArrayList<Integer>();
    	finish_time = new ArrayList<Integer>();
    	vertices = n;
    	edges = 0;
    	time = 0;
    	for(int i = 0;i<vertices+1;i++) {
    		adj.add(new List<Integer>());
    		color.add(new Character('W'));
    		distance.add(-1);
    		parent.add(0);
    		discovery_time.add(-1);
    		finish_time.add(-1);
    	}
    }
    
    
    /*** Accessors ***/
    
  /**
   * Returns the number of edges in the graph
   * @return the number of edges
   */
    public int getNumEdges() {
        return edges;
    }
    
    /**
     * Returns the number of vertices in the graph
     * @return the number of vertices
     */
    public int getNumVertices() {
        return vertices;
    }
    
    /**
     * returns whether the graph is empty (no vertices)
     * @return whether the graph is empty
     */
    public boolean isEmpty() {
        return vertices == 0;
    }

    /**
     * Returns the value of the distance[v]
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the distance of vertex v
     * @throws IndexOutOfBoundsException when 
     * the precondition is violated
     */
    public Integer getDistance(Integer v) throws IndexOutOfBoundsException{
    	if(v < 0 || v > vertices) {
    		throw new IndexOutOfBoundsException("getDistance(): "
    				+ "vertex " + v + " is not in the graph. Cannot get distance.");
    	}
        return distance.get(v);
    }
    
    /**
     * Returns the value of the parent[v]
     * @param v a vertex in the graph
     * @precondition v <= vertices
     * @return the parent of vertex v
     * @throws IndexOutOfBoundsException when 
     * the precondition is violated
     */
    public Integer getParent(Integer v) throws IndexOutOfBoundsException {
    	if(v > vertices) {
    		throw new IndexOutOfBoundsException("getParent(): "
    				+ "vertex " + v + " is not in the graph. Cannot get parent.");
    	}
    	return parent.get(v);
    }
    
    /**
     * Returns the value of the color[v]
     * @param v a vertex in the graph
     * @precondition 0< v <= vertices
     * @return the color of vertex v
     * @throws IndexOutOfBoundsException when 
     * the precondition is violated
     */
    public Character getColor(Integer v) throws IndexOutOfBoundsException {
    	if(v < 0 || v > vertices) {
    		throw new IndexOutOfBoundsException("getColor(): "
    				+ "vertex " + v + " is not in the graph. Cannot get color.");
    	}
        return color.get(v);
        
    }
    
    /**
     * Returns the value of the discovery_time[v]
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the discovery time of vertex v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     */
    public Integer getDiscoveryTime(Integer v) throws IndexOutOfBoundsException {
    	if (v < 0 || v > vertices) {
    		throw new IndexOutOfBoundsException("getDiscoveryTime(): "
    				+ "vertex " + v + " is not in the graph. Cannot get discovery time.");
    	}
    	return discovery_time.get(v);
    }
    
    /**
     * Returns the value of the finish_time[v] 
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the finish time of vertex v
     * @throws IndexOutOfBoundsException when 
     * the precondition is violated
     */
    public Integer getFinishTime(Integer v) throws IndexOutOfBoundsException {
    	if (v < 0 || v > vertices) {
    		throw new IndexOutOfBoundsException("getFinishTime(): "
    				+ "vertex " + v + " is not in the graph. Cannot get finish time.");
    	}
    	return finish_time.get(v);
    }
    /*** Manipulation Procedures ***/
    
    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * @precondition, 0 < u, v <= vertices
     * @throws IndexOutOfBounds exception when the precondition
     * is violated
     */
    void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
    	if(u < 0) {
    		throw new IndexOutOfBoundsException("addDirectedEdge(): "
    				+ "u cannot be less than 0.");
    	}
    	if(v > vertices) {
    		throw new IndexOutOfBoundsException("addDirectedEdge(): "
    				+ "vertex is not in the graph.");
    	}
    	adj.get(u).addLast(v);
    	edges++;
    }
    
    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * and inserts u into the adjacent vertex list of v
     * @precondition, 0 < u, v <= vertices
     *  
     */
    void addUndirectedEdge(Integer u, Integer v) {
    	if(u < 0) {
    		throw new IndexOutOfBoundsException("addDirectedEdge(): "
    				+ "vertex cannot be less than 0.");
    	}
    	if(v > vertices) {
    		throw new IndexOutOfBoundsException("addDirectedEdge(): "
    				+ "vertex is not in the graph.");
    	}
    	adj.get(u).addLast(v);
    	adj.get(v).addLast(u);
    	edges++;
    }
    
    /*** Additional Operations ***/
    
    /**
     * Creates a String representation of the Graph
     * Prints the adjacency list of each vertex in the graph,
     * vertex: <space separated list of adjacent vertices>
     */
    @Override public String toString() {
        String result = "";
        for (int i = 1; i < vertices + 1; i++) {
        	result += i + ": " + adj.get(i).toString();
        }
        return result;
    }
    
    /**
    * Prints the current values in the parallel ArrayLists
    * after executing DFS. First prints the heading:
    * v <tab> c <tab> p <tab> d <tab> f 
    * Then, prints out this information for each vertex in the graph
    * Note that this method is intended purely to help you debug your code
    */
    public void printDFS() {
    	System.out.println("v\tc\tp\td\tf");
    	for (int i = 1; i < vertices + 1; i++) {
    		System.out.println(i + "\t" + color.get(i) + "\t" + parent.get(i) + "\t" + 
    				discovery_time.get(i) + "\t" + finish_time.get(i));
    	}
    }
    
    /**
     * Performs depth first search on this Graph
     * @precondition graph must not be empty
     * @throws IllegalStateException when 
     * precondition is violated
     */
    public void DFS() throws IllegalStateException {
    	if (isEmpty()) {
			throw new IllegalStateException("DFS(): "
					+ "Graph is empty. Cannot perform breath first search.");
		}
    	for (int i = 1; i < vertices; i++) {
    		color.set(i, 'W');
    		parent.set(i, 0);
    		discovery_time.set(i, -1);
    		finish_time.set(i, -1);
    	}
    	for (int j = 1; j < vertices; j++) {
    		if (color.get(j) == 'W') {
    			visit(j);
    			
    		}
    	}
    }
    
    /**
     * Visits every vertex in the graph
     * @param v a vertex in the graph
     * helper method for DFS
     */ 
    private void visit(Integer v) {
    	color.set(v, 'G');
    	discovery_time.set(v, ++time);
    	adj.get(v).pointIterator();
    	for (int k = 0; k < adj.get(v).getLength(); k++) {
    		int x = adj.get(v).getIterator();
    		if (color.get(x) == 'W') {
    			parent.set(x, v);
    			visit(x);
    		}
    		adj.get(v).advanceIterator();
    	}
    	color.set(v, 'B');
    	finish_time.set(v, ++time);
    }
    
    /**
     * Prints the current values in the parallel ArrayLists
     * after executing BFS. First prints the heading:
     * v <tab> c <tab> p <tab> d
     * Then, prints out this information for each vertex in the graph
     * Note that this method is intended purely to help you debug your code
     */
    public void printBFS() {
        System.out.println("v\tc\tp\td");
        for(int i = 1; i < vertices+1;i++) {
        	System.out.println(i + "\t" + color.get(i) + "\t" + parent.get(i) + "\t" + distance.get(i));
        }
    }
    
    /**
     * Performs breath first search on this Graph give a source vertex
     * @param source
     * @precondition graph must not be empty
     * @precondition source is a vertex in the graph
     * @throws IllegalStateException if the graph is empty
     * @throws IndexOutOfBoundsException when the source vertex
     */
	public void BFS(Integer source) throws IllegalStateException, IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalStateException("BFS(): "
					+ "Graph is empty. Cannot perform breath first search.");
		}
		if (source < 0 || source > vertices) {
			throw new IndexOutOfBoundsException("BFS(): "
					+ source + " is not in the graph. Cannot perform breath first search.");
		}
		for (int i = 1; i < vertices; i++) {
			color.set(i, 'W');
			distance.set(i, -1);
			parent.set(i, 0);
		}
		color.set(source, 'G');
		distance.set(source, 0);
		List<Integer> q = new List<Integer>();
		q.addLast(source);
		while (!q.isEmpty()) {
			int x = q.getFirst();
			q.removeFirst();
			adj.get(x).pointIterator();
			for (int j = 0; j < adj.get(x).getLength(); j++) {
				int y = adj.get(x).getIterator();
				if (color.get(y) == 'W') {
					color.set(y, 'G');
					distance.set(y, distance.get(x) + 1);
					parent.set(y, x);
					q.addLast(y);
				}
				adj.get(x).advanceIterator();
			}
			color.set(x, 'B');
		}
	}
    
    /**
     * Recursive method to make a String containing the path 
     * from the source to the destination vertex
     * @param source the source vertex when performing BFS
     * @param destination the destination vertex
     * @param a String containing the path
     * @return a String containing the path
     */
    //Prints to the console or to an output file given the or stream parameter
    public String printPath(Integer source, Integer destination, String path) {
    	if (source == destination) {
    		return source + " " + path;
    	} else if (parent.get(destination) == 0) {
    		return "\nNo path from " + source + " to " + destination + " exists";
    	}
        return printPath(source, parent.get(destination), destination + " " + path);
    }
}