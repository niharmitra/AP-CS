import java.util.ArrayList;

/*
 * Implements Dijkstra's algorithm to find the shortest distances
 * Returns the single source shortest path as a sequence of vertices
 * Uses a hash map for the graph
 */
public class Dijkstra {
	// Whether each node has been checked or not
	ArrayList<Boolean> checked = new ArrayList<Boolean>();
	// Shortest distance to that node from startnode
	ArrayList<Integer> dist = new ArrayList<Integer>();
	// Previous node in the path if applicable
	ArrayList<Integer> node = new ArrayList<Integer>();

	Graph graph;

	/*
	 * Creates an enum to represent the nodes, each node has a numeric value for
	 * the graph
	 */
	public enum n {
		// Node names
		A(0), B(1), C(2), D(3), E(4);

		// Value of the node and its value
		private int nodeVal;

		public int val() {
			return nodeVal;
		}

		n(int val) {
			this.nodeVal = val;
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.setEdge(n.A.val(), n.E.val(), 5);
		graph.setEdge(n.B.val(), n.C.val(), 1);
		graph.setEdge(n.B.val(), n.D.val(), 6);
		graph.setEdge(n.C.val(), n.A.val(), 2);
		graph.setEdge(n.C.val(), n.E.val(), 10);
		graph.setEdge(n.D.val(), n.B.val(), 6);
		graph.setEdge(n.D.val(), n.A.val(), 8);
		graph.setEdge(n.E.val(), n.B.val(), 3);
		graph.print();
	}

	private void takeInput() {

	}

	/**
	 * Dijkstra's algorithm
	 * 
	 * @param startNode
	 * @param graph
	 */
	public void dijkstra(int startNode, Graph graph) {
		this.graph = graph;
		// Initializes arraylists as appropriate
		for (int i = 0; i < graph.getSize(); i++) {
			checked.add(false);
			dist.add(Integer.MAX_VALUE);
			node.add(null);
		}

		// Update and select start node
		checked.set(startNode, true);
		dist.set(startNode, 0);

		// Continue running the algorithm until no unselected nodes remain
		while (checked.contains(false)) {
			updateUnselectedNodes();
			selectMin();
		}
	}

	/**
	 * Updates the unselected nodes that are connected to a selected node
	 */
	private void updateUnselectedNodes() {
		for (int i = 0; i < graph.getSize(); i++) {
			if(checked.get(i) == false) {
				
			}
		}
	}

	/**
	 * Finds the closest node of the unselected ones
	 */
	private void selectMin() {
	}
}