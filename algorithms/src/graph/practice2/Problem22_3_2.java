package graph.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problem22_3_2 {
	private int time = 0;

	public void dfs(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.get(x).add(y);
		}

		int color[] = new int[n];
		int[] discoveryTime = new int[n], finishTime = new int[n];
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				Stack<Integer> dfsOrder = dfs(i, color, discoveryTime, finishTime, graph);
				System.out.println(dfsOrder);
			}
		}

		System.out.println("DiscoveryTime: " + Arrays.toString(discoveryTime));
		System.out.println("FinishTime: " + Arrays.toString(finishTime));
	}

	private Stack<Integer> dfs(int source, int[] color, int[] discoveryTime, int[] finishTime,
			Map<Integer, List<Integer>> graph) {
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		color[source] = 1;
		Stack<Integer> dfsOrder = new Stack<>();
		while (!stack.isEmpty()) {
			int node = stack.peek();
			List<Integer> adjacencyList = graph.getOrDefault(node, new ArrayList<>());
			for (Integer adjacent : adjacencyList)
				if (color[adjacent] == 0) {
					stack.push(adjacent);
					color[adjacent] = 1;
				}
			if (node == stack.peek()) {
				int finishedNode = stack.pop();
				time += 1;
				finishTime[finishedNode] = time;
				color[finishedNode] = 2;
				dfsOrder.push(finishedNode);
			}
		}
		return dfsOrder;
	}

	public static void main(String[] args) {
		Problem22_3_2 problem = new Problem22_3_2();
		int n = 10;
		int[][] edges = new int[][] { { 0, 2 }, { 0, 6 }, { 0, 3 }, { 2, 5 }, { 6, 2 }, { 5, 6 }, { 3, 7 }, { 3, 8 },
				{ 7, 9 }, { 9, 7 }, { 8, 0 }, { 1, 4 }, { 1, 8 }, { 4, 8 } };

		problem.dfs(n, edges);
	}
}
