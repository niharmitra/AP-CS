import java.util.ArrayList;


public class Solver {
	/**
	 * 
	 * @param graph An unordered collection of points
	 * @return A hamiltonian path for the given graph
	 */
	public static ArrayList<MyPoint> pathfinder(ArrayList<MyPoint> graph) {
		ArrayList<MyPoint> path = new ArrayList<MyPoint>();
		//The TSP path is a type of hamiltonian path
		path = TSPOracle.tsp(graph);
		return path;
	}
}
