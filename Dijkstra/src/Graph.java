import java.util.ArrayList;

/* Represents a graph through an adjacency matrix
 * If wanted, nodes can be represented through an enum
 * T is for the type of edges
 */
public class Graph {	
	//Adjacency matrix represents the edges
	ArrayList<ArrayList<Integer>> matrix;
	
	/**
	 * Constructor of the graph starts with the size of the graph
	 * @param size Number of nodes in the graph
	 */
	public Graph(int size) {
		 matrix = new ArrayList<ArrayList<Integer>>(size);
		 //Temporary arraylist of infinity to copy into matrix
		 ArrayList<Integer> infinity = new ArrayList<Integer>(size);
		 for(Integer num : infinity) {
			 num = Integer.MAX_VALUE;
		 }
		 for(ArrayList<Integer> list : matrix) {
			 list.addAll(infinity);
		 }
	}

	/**
	 * Adds an edge between the two nodes, of magnitude "value"
	 */
	public void addEdge(int node1, int node2, int value) {
		
	}
}
