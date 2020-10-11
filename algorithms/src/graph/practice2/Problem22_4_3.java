package graph.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Detect a cylcle.
 * 
 * @author rajan-c
 *
 */
public class Problem22_4_3 {
	public boolean doesHaveCycle(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
		}

		System.out.println(graph);

		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				if (dfs(i, graph, color))
					return true;
			}
		}
		return false;
	}

	private boolean dfs(int source, Map<Integer, List<Integer>> graph, int[] color) {
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (int adjacent : adjacents) {
			if (color[adjacent] == 1)
				return true;
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				if (dfs(adjacent, graph, color))
					return true;
			}
		}
		color[source] = 2;
		return false;
	}

	public static void main(String[] args) {
		int vertices = 14;
		int[][] edges = new int[][] { { 0, 5 }, { 0, 4 }, { 0, 11 }, { 1, 4 }, { 1, 8 }, { 1, 2 }, { 2, 5 }, { 2, 6 },
				{ 2, 9 }, { 3, 2 }, { 3, 6 }, { 3, 13 }, { 3, 7 }, { 5, 8 }, { 5, 12 }, { 6, 5 }, { 8, 7 }, { 9, 11 },
				{ 9, 10 }, { 10, 13 }, { 12, 9 } };
		System.out.println(new Problem22_4_3().doesHaveCycle(vertices, edges));
	}
}
