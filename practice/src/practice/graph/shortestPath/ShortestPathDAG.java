package practice.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Shortest path in a DAG.
 * 
 * @author rajan-c
 *
 */
public class ShortestPathDAG {

	public static long[] shortestPathInDAG(int vertices, int[][] edges, int source) {
		Map<Integer, List<int[]>> graph = new HashMap<>();

		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}

		Stack<Integer> topologicalOrder = new Stack<>();
		int[] color = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				dfs(i, graph, color, topologicalOrder);
			}
		}

		long[] distance = new long[vertices];
		int[] parent = new int[vertices];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		Arrays.fill(parent, -1);
		while (!topologicalOrder.isEmpty()) {
			int node = topologicalOrder.pop();
			List<int[]> adjacents = graph.getOrDefault(node, new ArrayList<>());
			for (int[] adjacent : adjacents) {
				if (distance[node] + adjacent[1] < distance[adjacent[0]]) {
					distance[adjacent[0]] = distance[node] + adjacent[1];
					parent[adjacent[0]] = node;
				}
			}
		}
		System.out.println(Arrays.toString(parent));
		return distance;
	}

	private static void dfs(int source, Map<Integer, List<int[]>> graph, int[] color, Stack<Integer> stack) {
		List<int[]> adjacencyList = graph.getOrDefault(source, new ArrayList<>());
		for (int[] adjacent : adjacencyList) {
			if (color[adjacent[0]] == 0) {
				color[adjacent[0]] = 1;
				dfs(adjacent[0], graph, color, stack);
			}
		}
		color[source] = 2;
		stack.add(source);
	}

	public static void main(String[] args) {
		int vertices = 6;
		int[][] edges = new int[][] { { 0, 1, 5 }, { 0, 2, 3 }, { 1, 2, 2 }, { 1, 3, 6 }, { 2, 3, -1 }, { 2, 4, 4 },
				{ 2, 5, 2 }, { 3, 5, 1 }, { 3, 4, -1 }, { 4, 5, -2 } };

		long[] distance = shortestPathInDAG(vertices, edges, 1);
		System.out.println(Arrays.toString(distance));
	}
}
