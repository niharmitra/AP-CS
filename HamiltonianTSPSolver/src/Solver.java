import java.util.ArrayList;


public class Solver {
	public static ArrayList<MyPoint> pathfinder(ArrayList<MyPoint> graph) {
		ArrayList<MyPoint> path = new ArrayList<MyPoint>();
		//The TSP path is a hamiltonian path
		path = TSPOracle.tsp(graph);
		return path;
	}
}
