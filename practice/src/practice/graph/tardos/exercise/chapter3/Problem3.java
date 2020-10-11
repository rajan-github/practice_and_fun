package practice.graph.tardos.exercise.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problem3 {
	public static boolean topologicalOrder(int n, int[][] edges, Stack<Integer> nodes) {
		Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			adjacencyMap.putIfAbsent(x, new ArrayList<>());
			adjacencyMap.get(x).add(y);
		}

		int[] color = new int[n];
		int[] parents = new int[n];
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				parents[i] = -1;
				boolean cycleFound = dfs(i, adjacencyMap, color, parents, nodes);
				if (cycleFound)
					return !cycleFound;
			}
		}
		return true;
	}

	private static boolean dfs(int source, Map<Integer, List<Integer>> adjacencyMap, int[] color, int[] parents,
			Stack<Integer> nodes) {
		List<Integer> adjacencyList = adjacencyMap.getOrDefault(source, new ArrayList<>());

		for (int adjacent : adjacencyList) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				parents[adjacent] = source;
				boolean cycleFound = dfs(adjacent, adjacencyMap, color, parents, nodes);
				if (cycleFound) {
					return cycleFound;
				}

			} else if (color[adjacent] == 1) {
				nodes.clear();
				nodes.add(adjacent);
				int node = source;
				while (node != adjacent) {
					nodes.add(node);
					node = parents[node];
				}
				return true;
			}
		}
		nodes.push(source);
		color[source] = 2;
		return false;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
		Stack<Integer> stack = new Stack<>();
		System.out.println(topologicalOrder(n, edges, stack) + ",\n " + stack);

		stack.clear();
		n = 3;
		edges = new int[][] { { 0, 1 }, { 0, 2 }, { 2, 1 } };
		System.out.println(topologicalOrder(n, edges, stack) + ",\n " + stack);

		stack.clear();
		n = 3;
		edges = new int[][] { { 0, 1 }, { 0, 2 } };
		System.out.println(topologicalOrder(n, edges, stack) + ",\n " + stack);

		stack.clear();
		n = 3;
		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		System.out.println(topologicalOrder(n, edges, stack) + ",\n " + stack);

		stack.clear();
		n = 5;
		edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 4 } };
		System.out.println(topologicalOrder(n, edges, stack) + ",\n " + stack);
	}
}
