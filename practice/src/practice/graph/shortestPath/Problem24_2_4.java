package practice.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Give an efficient algorithm to count the total number of paths in a directed
 * acyclic graph. Analyze your algorithm.
 * 
 * @author rajan-c
 *
 */
public class Problem24_2_4 {
	public static int countPaths(int vertices, int[][] edges, int source) {
		if (vertices <= 0 || edges == null || edges.length == 0)
			return 0;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.get(x).add(y);
		}
		List<Integer> topologicalSort = new ArrayList<>();
		dfs(source, graph, new int[vertices], topologicalSort);
		int[] paths = new int[vertices];
		for (Integer vertex : topologicalSort) {
			List<Integer> adjacents = graph.getOrDefault(vertex, new ArrayList<>());
			for (Integer adjacent : adjacents) {
				paths[vertex] += (paths[adjacent] + 1);
			}
		}
		return Arrays.stream(paths).sum();
	}

	private static void dfs(int source, Map<Integer, List<Integer>> graph, int[] color, List<Integer> topologicalSort) {
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] += 1;
				dfs(adjacent, graph, color, topologicalSort);
			}
		}
		color[source] += 1;
		topologicalSort.add(source);
	}

	public static void main(String[] args) {

		int vertices = 5;
		int[][] edges = new int[][] { { 0, 1 }, { 0, 4 }, { 0, 2 }, { 2, 3 }, { 1, 3 }, { 4, 3 } };
		System.out.println(countPaths(vertices, edges, 0));
	}
}
