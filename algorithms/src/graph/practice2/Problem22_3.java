package graph.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem22_3 {
	public List<Integer> eulerTour(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = CommonMethods.createGraph(n, edges);
		int[] indegree = new int[n], outdegree = new int[n];
		if (!doesGraphHasEulerTour(n, graph, indegree, outdegree))
			return null;
		List<Integer> eulerTour = new ArrayList<>();
		
		return eulerTour;
	}

	private boolean doesGraphHasEulerTour(int n, Map<Integer, List<Integer>> graph, int[] indegree, int[] outdegree) {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			int vertex = entry.getKey();
			List<Integer> adjacents = entry.getValue();
			outdegree[vertex] = adjacents.size();
			for (Integer adjacent : adjacents)
				indegree[adjacent] += 1;
		}

		for (int i = 0; i < indegree.length; i++)
			if (indegree[i] != outdegree[i])
				return false;
		return true;
	}

}
