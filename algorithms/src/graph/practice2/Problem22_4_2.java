package graph.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Assumtion is directed acyclic graph.
 * 
 * @author rajan-c
 *
 */
public class Problem22_4_2 {
	public int countPath(int n, int[][] edges, int source, int destination) {
		if (n <= 0 || edges == null || edges.length == 0)
			return 0;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.get(x).add(y);
		}
		return dfs(source, graph, destination, new int[n]);
	}

	private int dfs(int source, Map<Integer, List<Integer>> graph, int target, int[] color) {
		if (source == target)
			return 1;
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		int pathCount = 0;
		for (Integer adjacent : adjacents) {
			pathCount += dfs(adjacent, graph, target, color);
		}
		return pathCount;
	}

	public static void main(String[] args) {
		Problem22_4_2 pathCounter = new Problem22_4_2();
		int[][] edges = new int[][] { { 0, 5 }, { 0, 4 }, { 0, 11 }, { 1, 4 }, { 1, 8 }, { 1, 2 }, { 2, 5 }, { 2, 6 },
				{ 2, 9 }, { 3, 2 }, { 3, 6 }, { 3, 13 }, { 3, 7 }, { 5, 8 }, { 5, 12 }, { 6, 5 }, { 8, 7 }, { 9, 11 },
				{ 9, 10 }, { 10, 12 }, { 12, 9 } };
		System.out.println(pathCounter.countPath(14, edges, 3, 9));
	}
}
