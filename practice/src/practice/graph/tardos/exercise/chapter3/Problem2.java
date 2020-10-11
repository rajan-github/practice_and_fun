package practice.graph.tardos.exercise.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
	public static List<Integer> findCycleInGraph(int n, int[][] edges) {
		List<Integer> cycle = new ArrayList<>();
		if (n <= 0 || edges == null)
			return cycle;
		Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			adjacencyMap.putIfAbsent(x, new ArrayList<>());
			adjacencyMap.get(x).add(y);

			adjacencyMap.putIfAbsent(y, new ArrayList<>());
			adjacencyMap.get(y).add(x);
		}
		int[] color = new int[n];
		int[] parents = new int[n];
		int[] distance = new int[n];

		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				parents[i] = -1;
				List<Integer> cycleNodes = dfs(i, adjacencyMap, color, parents, distance);
				if (cycleNodes != null)
					return cycleNodes;
			}
		}
		return cycle;
	}

	private static List<Integer> dfs(int source, Map<Integer, List<Integer>> adjacencyMap, int[] color, int[] parents,
			int[] distance) {
		List<Integer> adjacencyList = adjacencyMap.getOrDefault(source, new ArrayList<>());
		for (int adjacent : adjacencyList) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				parents[adjacent] = source;
				distance[adjacent] = distance[source] + 1;
				List<Integer> cycle = dfs(adjacent, adjacencyMap, color, parents, distance);
				if (cycle != null)
					return cycle;
			} else {
				if (Math.abs(distance[adjacent] - distance[source]) > 1) {
					List<Integer> cycle = new ArrayList<>();
					cycle.add(adjacent);
					Integer node = source;
					while (node != adjacent) {
						cycle.add(node);
						node = parents[node];
					}
					return cycle;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
		System.out.println(findCycleInGraph(n, edges));

		n = 3;
		edges = new int[][] { { 0, 1 }, { 0, 2 }, { 2, 1 } };
		System.out.println(findCycleInGraph(n, edges));

		n = 3;
		edges = new int[][] { { 0, 1 }, { 0, 2 } };
		System.out.println(findCycleInGraph(n, edges));

		n = 5;
		edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 4 } };
		System.out.println(findCycleInGraph(n, edges));
	}

}
