import java.util.ArrayList;

/* Represents a graph through an adjacency list
 * Implements Comparable for usage in a Priority Queue
 */
public class Node implements Comparable<Node> {
	/* The adjacency list of values of the edge to the corresponding node
	 * Instead of ordered pairs, the adjacency list simply contains the value of the edge to each other node
	 */
	public ArrayList<Double> adjList;

	// The distance to the start node (defaults to infinity)
	public double srcDist = Double.POSITIVE_INFINITY;

	public double getSrcDist() {
		return srcDist;
	}

	public void setSrcDist(double dist) {
		srcDist = dist;
	}

	Node prevNode = null;

	public void setPrevNode(Node node) {
		prevNode = node;
	}

	String name;

	public String getName() {
		return name;
	}

	/**
	 * Creates a node with the specified name, given the number of other nodes
	 * 
	 * @param name Name of this node
	 * @param numNodes The number of other nodes
	 */
	public Node(String name, int numNodes) {
		this.name = name;
		adjList = new ArrayList<Double>();
		for(int i = 0; i < numNodes; i++) {
			adjList.add(Double.POSITIVE_INFINITY);
		}
	}

	/**
	 * Creates a node with the specified name and uses the given doubles as the
	 * adjacency matrix
	 * 
	 * @param name Name of the node
	 * @param args Use null instead of positive infinity
	 */
	public Node(String name, Double... args) {
		this.name = name;
		adjList = new ArrayList<Double>();
		for(Double d : args) {
			if(d == null) {
				adjList.add(Double.POSITIVE_INFINITY);
			} else {
				adjList.add(d);
			}
		}
	}
	
	/**
	 * Adds a value to the end of the adjacency list
	 * @param value The value of the edge added
	 */
	public void addEdge(double value) {
		adjList.add(value);
	}
	
	/**
	 * Changes the value of an existing edge in the adjacency list
	 * @param index The index of the node
	 * @param value The new value of the edge
	 */
	public void setEdge(int index, double value) {
		adjList.set(index, value);
	}
	
	/**
	 * Gets the value of an edge in the adjacency matrix
	 * @param index of the node for which you want the edge to
	 * @return The distance to that node from this node
	 */
	public double getEdge(int index) {
		return adjList.get(index);
	}

	/**
	 * Overrides the default compare to in order to be compatible with priority
	 * queue Bases comparison on the source distance, since the purpose is
	 * finding the shortest path
	 */
	@Override
	public int compareTo(Node node) {
		if(this.srcDist == node.getSrcDist()) {
			return 0;
		} else if(this.srcDist < node.getSrcDist()) {
			return -1;
		} else if(this.srcDist > node.getSrcDist()) {
			return 1;
		}
		return 0;
	}

	/**
	 * Prints the node's name and the previous node
	 */
	public void printResult() {
		//If there is no previous node, no path was found
		if(prevNode != null) {
			System.out.println(name + "," + prevNode.getName());
		} else {
			System.out.println(name + "," + "-");
		}
	}
}
