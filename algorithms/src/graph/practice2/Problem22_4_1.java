package graph.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Toplogical sort.
 * 
 * @author rajan-c
 *
 */
public class Problem22_4_1 {
	private int time = 0;

	public int[] topologicalSort(int n, int[][] edges) {
		if (n <= 0)
			return new int[0];
		int[] topologicalSort = new int[n];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++)
			graph.put(i, new ArrayList<>());

		for (int[] edge : edges)
			graph.get(edge[0]).add(edge[1]);

		int[] color = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (color[i] == 0)
				dfs(i, graph, color, stack);
		}

		int index = 0;
		while (!stack.isEmpty())
			topologicalSort[index++] = stack.pop();
		return topologicalSort;
	}

	private void dfs(int source, Map<Integer, List<Integer>> graph, int[] color, Stack<Integer> stack) {
		time = time + 1;
		color[source] = 1;
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				dfs(adjacent, graph, color, stack);
			}
		}
		time = time + 1;
		stack.push(source);
		color[source] = 2;
	}

	public static void main(String[] args) {
		int vetices = 14;
		int[][] edges = new int[][] { { 0, 5 }, { 0, 4 }, { 0, 11 }, { 1, 4 }, { 1, 8 }, { 1, 2 }, { 2, 5 }, { 2, 6 },
				{ 2, 9 }, { 3, 2 }, { 3, 6 }, { 3, 13 }, { 3, 7 }, { 5, 8 }, { 5, 12 }, { 6, 5 }, { 8, 7 }, { 9, 11 },
				{ 9, 10 }, { 10, 12 }, { 12, 9 } };
		int[] topologicalSort = new Problem22_4_1().topologicalSort(vetices, edges);
		System.out.println(Arrays.toString(topologicalSort));
	}

}

class Vertex {
	int node;
	int finishTime;

	public Vertex(int _node, int _finishTime) {
		this.node = _node;
		this.finishTime = _finishTime;
	}
}
