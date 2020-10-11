package practice.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import practice.graph.Utilities;

public class Problem24_3_4 {
	public static boolean validateShortestPath(int vertices, int[][] edges, int[] parents, long[] weight) {
		int sourceIndex = findValue(parents, -1);
		if (sourceIndex < 0 || weight[sourceIndex] != 0)
			return false;
		Map<Integer, List<int[]>> graph = Utilities.makeGraph(edges);
		for (int i = 0; i < weight.length; i++) {
			if (i != sourceIndex) {
				int parent = parents[i];
				List<int[]> adjacents = graph.get(parent);
				for (int[] adjacent : adjacents) {
					if (adjacent[0] == i) {
						if (weight[i] != weight[parent] + adjacent[1])
							return false;
						break;
					}
				}
			}
		}

		long[] newWeight = new long[vertices];
		int[] newParent = new int[vertices];
		bfs(graph, newWeight, newParent, sourceIndex);
		for (int i = 0; i < vertices; i++)
			if (newWeight[i] < weight[i])
				return false;

		return true;
	}

	private static void bfs(Map<Integer, List<int[]>> graph, long[] weight, int[] parent, int source) {
		Queue<Integer> queue = new LinkedList<>();
		Arrays.fill(weight, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		weight[source] = 0;
		queue.add(source);
		int[] color = new int[weight.length];
		color[source] = 1;

		while (queue.isEmpty()) {
			int node = queue.remove();
			List<int[]> adjacents = graph.getOrDefault(node, new ArrayList<>());
			for (int[] adjacent : adjacents) {
				long newWeight = weight[node] + adjacent[1];
				if (newWeight > weight[adjacent[0]]) {
					weight[adjacent[0]] = newWeight;
					parent[adjacent[0]] = node;
				}
				if (color[adjacent[0]] == 0) {
					color[adjacent[0]] = 1;
					queue.add(adjacent[0]);
				}

			}
		}
	}

	private static int findValue(int[] array, int target) {
		for (int i = 0; i < array.length; i++)
			if (array[i] == target)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		int vertices = 5;
		int[][] edges = new int[][] { { 0, 1, 3 }, { 0, 2, 5 }, { 1, 3, 6 }, { 2, 1, 1 }, { 2, 4, 6 }, { 2, 3, 4 },
				{ 3, 4, 2 }, { 4, 3, 7 }, { 4, 0, 3 } };

		int[] parents = new int[vertices];
		long[] weights = new long[vertices];

		Problem24_3_1.shortestPath(vertices, edges, 0, parents, weights);
		boolean result = validateShortestPath(vertices, edges, parents, weights);
		System.out.println(result);
	}
}
