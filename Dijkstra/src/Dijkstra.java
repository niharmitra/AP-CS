import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Implements Dijkstra's algorithm to find the shortest distances
 * Returns the single source shortest path as a sequence of vertices
 * Uses a hash map for the graph
 */
public class Dijkstra {
	public static void main(String[] args) {
		
	}
	
	public static void dijkstra(ArrayList<Node> graph, Node startNode) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>(graph);
		
		startNode.srcDist = 0;
		
		while(!queue.isEmpty()) {
			//Top one is the shortest source distance, so apply
			//It's adjacency list to all other relevant nodes
			for(int i=0; i<graph.size(); i++) {
				double tempDist = graph.get(i).srcDist = queue.peek().adjList.get(i);
				if(tempDist < graph.get(i).getSrcDist()) {
					graph.get(i).srcDist = tempDist;
					graph.get(i).prevNode = queue.peek();
				}
			}
			queue.poll();
		}
	}
}