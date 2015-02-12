import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Implements Dijkstra's algorithm to find the shortest distances
 * Returns the single source shortest path as a sequence of vertices
 * Represents a graph through an adjacency list
 */
public class Dijkstra {
	public static void main(String[] args) {
		Node a = new Node("A", 0.0, 2.0, null, null);
		Node b = new Node("B", 2.0, 0.0, 2.0, 5.0);
		Node c = new Node("C", 3.0, null, null, null);
		Node d = new Node("D", 1.0, null, null, 0.0);
				
		ArrayList<Node> graph = new ArrayList<Node>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		dijkstra(graph, d);
	}

	/**
	 * Runs dijkstra's algorithm on the given graph, returning the single source
	 * path as the sequence of vertices
	 * 
	 * @param graph The graph to run the algorithm on
	 * @param startNode The starting node for the algorithm
	 */
	public static void dijkstra(ArrayList<Node> graph, Node startNode) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>(graph);
		startNode.setSrcDist(0);

		while(!queue.isEmpty()) {
			/* Top one is the shortest source distance, so apply
			   It's adjacency list to all other relevant nodes */
			updateNodes(queue.peek(), graph);
			queue.poll();
		}
		
		//Prints results
		for(Node node : graph) {
			node.printResult();
		}
	}
	
	/**
	 * Updates the nodes if the path through the "current" node is faster
	 */
	private static void updateNodes(Node currentNode, ArrayList<Node> graph) {
		// Checks if the a path from the current node is shorter than the existing one
		for(int i = 0; i < graph.size(); i++) {
			double pathDist = currentNode.getSrcDist() + currentNode.getEdge(i);
			if(pathDist < graph.get(i).getSrcDist()) {
				graph.get(i).setSrcDist(pathDist);
				graph.get(i).setPrevNode(currentNode);
			}
		}
	}
}