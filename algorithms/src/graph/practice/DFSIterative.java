package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import auxiliaryMethods.CommonMethods;

/**
 * DFS iterative version.
 * 
 * @author rajan-c
 *
 */
public class DFSIterative {
	public static int[] dfs(int n, int[][] edges) {
		Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
		for (int i = 1; i <= n; i++)
			adjacencyMap.put(i, new HashSet<>());
		for (int[] edge : edges)
			adjacencyMap.get(edge[0]).add(edge[1]);

		Set<Integer> grayVertices = new HashSet<>(), blackVertices = new HashSet<>();
		Stack<Integer> stack = new Stack<>(), remaining = new Stack<>();
		int source = 1;
		stack.add(source);
		grayVertices.add(source);
		boolean taken;
		int[] dfs = new int[n];
		int index = 0;
		while (!stack.isEmpty() || !remaining.isEmpty()) {
			int node;
			if (!stack.isEmpty())
				node = stack.pop();
			else
				node = remaining.pop();
			dfs[index++] = node;
			taken = false;
			Set<Integer> adjacencySet = adjacencyMap.get(node);
			for (int adjacent : adjacencySet) {
				if (!grayVertices.contains(adjacent) && !blackVertices.contains(adjacent)) {
					if (!taken) {
						stack.push(adjacent);
						taken = !taken;
						grayVertices.add(adjacent);
					} else
						remaining.push(adjacent);
				}
			}
		}
		return dfs;
	}

	public static void main(String[] args) {
		CommonMethods.display(dfs(5, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 5 } }));
	}
}
