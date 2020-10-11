package practice.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem24_1_4 {
	public static boolean shortestPath(int vertices, int[][] edges, int[] tree) {
		Arrays.fill(tree, -1);
		Map<Integer, Long> weightMap = new HashMap<>();
		weightMap.put(0, 0L);
		for (int i = 1; i < vertices; i++) {
			for (int[] edge : edges) {
				int x = edge[0], y = edge[1];
				long weight = weightMap.getOrDefault(y, (long) Integer.MAX_VALUE);
				long newWeight = weightMap.getOrDefault(x, (long) Integer.MAX_VALUE) + edge[2];
				if (weight > newWeight) {
					weightMap.put(y, newWeight);
					tree[y] = x;
				}
			}
		}

		boolean doesCycleExist = false;
		List<Integer> cycleVertices = new ArrayList<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			if (weightMap.getOrDefault(y,
					(long) Integer.MAX_VALUE) > weightMap.getOrDefault(x, (long) Integer.MAX_VALUE) + edge[2]) {
				doesCycleExist = true;
				cycleVertices.add(y);
			}
		}
		followAndSetMinimum(cycleVertices, tree, weightMap);
		System.out.println(weightMap);
		return !doesCycleExist;
	}

	private static void followAndSetMinimum(List<Integer> cycleNode, int[] tree, Map<Integer, Long> weightMap) {
		if (cycleNode.isEmpty())
			return;
		Set<Integer> marked = new HashSet<>();
		for (int vertex : cycleNode) {
			marked.add(vertex);
			weightMap.put(vertex, Long.MIN_VALUE);
			int parent = tree[vertex];
			while (parent != vertex) {
				weightMap.put(parent, Long.MIN_VALUE);
				parent = tree[parent];
			}
		}
	}

	public static void main(String[] args) {
		int vertices = 3;
		int[][] edges = new int[][] { { 0, 1, 1 }, { 1, 2, -6 }, { 2, 1, 3 } };
//		shortestPath(vertices, edges, new int[3]);

		vertices = 6;
		edges = new int[][] { { 0, 1, 1 }, { 1, 2, 4 }, { 1, 3, 5 }, { 2, 4, -6 }, { 4, 2, 3 }, { 3, 5, 6 },
				{ 5, 3, -3 } };

		shortestPath(vertices, edges, new int[6]);
	}
}
