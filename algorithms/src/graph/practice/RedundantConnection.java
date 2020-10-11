package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RedundantConnection {
	public static int[] findRedundantConnection(int[][] edges) {
		Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			if (!adjacentMap.containsKey(x))
				adjacentMap.put(x, new HashSet<>());
			if (!adjacentMap.containsKey(y))
				adjacentMap.put(y, new HashSet<>());

			adjacentMap.get(x).add(y);
			adjacentMap.get(y).add(x);
		}

		int source = edges[0][0];
		Set<Integer> graySet = new HashSet<>();
		graySet.add(source);
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		Set<Integer> cycleNodes = getCycleNodes(adjacentMap, source, graySet, new HashSet<>(), stack, -1);
		if (cycleNodes != null) {
			int index = edges.length - 1;
			while (index >= 0) {
				int[] edge = edges[index];
				if (cycleNodes.contains(edge[0]) && cycleNodes.contains(edge[1]))
					return edge;
				index--;
			}
		}
		return null;
	}

	private static Set<Integer> getCycleNodes(Map<Integer, Set<Integer>> graph, int source, Set<Integer> gray,
			Set<Integer> black, Stack<Integer> stack, int parent) {
		Set<Integer> adjacents = graph.get(source);
		for (int node : adjacents) {
			if (node != parent) {
				if (gray.contains(node)) {
					Set<Integer> cycleNodes = new HashSet<>();
					while (!stack.isEmpty()) {
						int v = stack.pop();
						cycleNodes.add(v);
						if (v == node)
							break;
					}
					return cycleNodes;
				}
				if (!black.contains(node)) {
					gray.add(node);
					stack.push(node);
					Set<Integer> cycle = getCycleNodes(graph, node, gray, black, stack, source);
					if (cycle != null)
						return cycle;
				}
			}
		}
		gray.remove(source);
		black.add(source);
		if (!stack.isEmpty())
			stack.pop();
		return null;
	}

	private static Set<Integer> getCycleNodesIterative(Map<Integer, Set<Integer>> graph, int source) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> graySet = new HashSet<>(), blackSet = new HashSet<>();
		stack.add(source);
		graySet.add(source);
		int parent = -1;
		outer: while (!stack.isEmpty()) {
			source = stack.pop();
			Set<Integer> adjacents = graph.get(source);
			for (int node : adjacents) {
				if (node != parent) {
					if (graySet.contains(node)) {
// found cycle.
					}
					if (!blackSet.contains(node)) {
						parent = source;
						stack.add(node);
						graySet.add(node);
					}
				}
			}

		}
		return null;
	}

	public static void main(String[] args) {
		int[] edge = findRedundantConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } });
		System.out.println(edge[0] + ", " + edge[1]);
	}
}
