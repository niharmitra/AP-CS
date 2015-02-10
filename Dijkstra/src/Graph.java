import java.util.ArrayList;

/* Represents a graph through an adjacency matrix
 * If wanted, nodes can be represented through an enum
 */
public class Graph {
	// Adjacency matrix represents the edges
	ArrayList<ArrayList<Integer>> matrix;
	private int size;
	public int getSize() {return size;}

	/**
	 * Constructor of the graph starts with the size of the graph
	 * 
	 * @param size
	 *            Number of nodes in the graph
	 */
	public Graph(int size) {
		matrix = new ArrayList<ArrayList<Integer>>(size);
		this.size = size;
		// Temporary arraylist of infinity to copy into matrix
		Integer infinity = Integer.MAX_VALUE;

		// Makes each row in the adjacency arraylist of infinities
		for(int i = 0; i < size; i++) {
			// Creates the arraylist for the row
			matrix.add(new ArrayList<Integer>(size));
			for(int j = 0; j < size; j++) {
				matrix.get(i).add(infinity);
			}
		}
	}

	/**
	 * Prints out the graph as an adjacency matrix
	 */
	public void print() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(matrix.get(i).get(j) == Integer.MAX_VALUE) {
					//Prints infinity symbol for shortening
					System.out.print('\u221E');
				}
				else {
					System.out.print(matrix.get(i).get(j));
				}
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	/**
	 * Adds an edge between the two nodes, of magnitude "value"
	 */
	public void setEdge(int node1, int node2, int value) {
		// Adds the value to the appropriate spot in the adjacency matrix
		matrix.get(node1).set(node2, value);
	}

	/**
	 * Gets edge value between two nodes
	 */
	public int getEdge(int node1, int node2) {
		return matrix.get(node1).get(node2);
	}
}
