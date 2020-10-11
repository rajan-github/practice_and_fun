package graph.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem22_5_5 {
	public Map<Integer, List<Integer>> componentsInDirectedGraph(int n, int[][] edges) {
		Map<Integer, List<Integer>> components = new HashMap<>();

		if (n <= 0)
			return components;

		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
		}

		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				List<Integer> component = new ArrayList<>();
				dfs(i, graph, color, component);
				components.put(i, component);
			}
		}
		return components;
	}

	private void dfs(int source, Map<Integer, List<Integer>> graph, int[] color, List<Integer> component) {
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				component.add(adjacent);
				color[adjacent] = 1;
				dfs(adjacent, graph, color, component);
			}
		}
		color[source] = 2;
	}

	public static void main(String[] args) {
		int vertices = 10;
		int[][] edges = new int[][] { { 0, 2 }, { 0, 3 }, { 0, 6 }, { 1, 4 }, { 1, 8 }, { 2, 5 }, { 3, 7 }, { 3, 8 },
				{ 4, 8 }, { 5, 6 }, { 6, 2 }, { 7, 9 }, { 8, 0 }, { 9, 7 } };
		System.out.println(new Problem22_5_5().componentsInDirectedGraph(vertices, edges));
	}
}
