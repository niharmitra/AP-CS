import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Implements Dijkstra's algorithm to find the shortest distances
 * Returns the single source shortest path as a sequence of vertices
 * Represents a graph through an adjacency list
 */
public class Dijkstra {
	public static void main(String[] args) {
		Node a = new Node("A", 0.0, 8.0, null, null, null, 10.0, null, null);
		Node b = new Node("B", null, 0.0, 4.0, null, 10.0, null, null, null);
		Node c = new Node("C", null, null, 0.0, 3.0, null, null, null, null);
		Node d = new Node("D", null, null, null, 0.0, 25.0, 18.0, null, null);
		Node e = new Node("E", null, null, null, 9.0, 0.0, null, 7.0, null);
		Node f = new Node("F", 5.0, null, 3.0, null, 2.0, 0.0, null, null);
		Node g = new Node("G", null, null, null, 2.0, null, null, 0.0, 3.0);
		Node h = new Node("H", 4.0, 9.0, null, null, null, null, null, 0.0);

		ArrayList<Node> graph = new ArrayList<Node>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		graph.add(h);
		dijkstra(graph, g);
	}

	/**
	 * Runs dijkstra's algorithm on the given graph, returning the single source
	 * path as the sequence of vertices
	 * 
	 * @param graph The graph to run the algorithm on
	 * @param startNode The starting node for the algorithm
	 */
	public static void dijkstra(ArrayList<Node> graph, Node startNode) {
		startNode.setSrcDist(0);
		PriorityQueue<Node> queue = new PriorityQueue<Node>(graph);
		
		while(!queue.isEmpty()) {
			/*
			 * Top one is the shortest source distance, so apply its adjacency
			 * list to all other relevant nodes
			 */
			updateNodes(queue.poll(), graph);
		}

		// Prints results
		for(Node node : graph) {
			node.printResult();
		}
	}

	/**
	 * Updates the nodes if the path through the "current" node is faster
	 */
	private static void updateNodes(Node currentNode, ArrayList<Node> graph) {
		// Checks if the a path from the current node is shorter than the
		// existing one
		for(int i = 0; i < graph.size(); i++) {
			double pathDist = currentNode.getSrcDist() + currentNode.getEdge(i);
//			System.out.println(pathDist + "," + graph.get(i).getSrcDist());
			if(pathDist < graph.get(i).getSrcDist()) {
				graph.get(i).setSrcDist(pathDist);
				graph.get(i).setPrevNode(currentNode);
			}
		}
	}
}