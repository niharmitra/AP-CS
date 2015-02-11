import java.util.ArrayList;

/* Represents a graph through an adjacency list
 * Implements Comparable for usage in a Priority Queue
 */
public class Node implements Comparable {
	//The adjacency list of values of the edge to the corresponding node
	public ArrayList<Double> adjList;
	
	//The distance to the start node (defaults to infinity)
	public double srcDist = Double.POSITIVE_INFINITY;
	public double getSrcDist() {return srcDist;}
	
	//This is for the return value in Dijkstra's algorithm
	Node prevNode;
	String name;
	
	/**
	 * @param name
	 * 
	 */
	public Node(String name, int numNodes) {
		this.name = name;
		adjList = new ArrayList<Double>();
		for(int i=0; i<numNodes; i++) {
			adjList.add(Double.POSITIVE_INFINITY);
		}
	}
	
	/**
	 * Shorthand constructor, directly take adjList where null becomes changed to infinity
	 */
	public Node(double... args) {
		for(Double d : args) {
			if(d == null) {
				adjList.add(Double.POSITIVE_INFINITY);
			}
			else {
				adjList.add(d);
			}
		}
	}
	
	@Override
	public int compareTo(Object node) {
		if(this.srcDist == ((Node) node).getSrcDist()) {
			return 0;
		}
		else if(this.srcDist > ((Node) node).getSrcDist()) {
			return -1;
		}
		else if(this.srcDist < ((Node) node).getSrcDist()) {
			return 1;
		}
		return 0;
	}
}
