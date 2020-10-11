package graph.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem22_5_7 {
	private int time = 0;

	public boolean isGraphSemiconnected(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
		}

		PriorityQueue<Vertex> finishingTimes = new PriorityQueue<>(
				(Vertex x, Vertex y) -> Integer.compare(y.finishingTime, x.finishingTime));
		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				dfs(i, graph, color, finishingTimes);
			}
		}

		Vertex node = finishingTimes.remove();
		return dfs(node.id, graph, new int[n]) == n;
	}

	private void dfs(int source, Map<Integer, List<Integer>> graph, int[] color, PriorityQueue<Vertex> finishingTime) {
		time += 1;
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				dfs(adjacent, graph, color, finishingTime);
			}
		}
		time += 1;
		color[source] = 2;
		finishingTime.add(new Vertex(source, time));
	}

	private int dfs(int source, Map<Integer, List<Integer>> graph, int[] color) {
		color[source] = 1;
		int traversedNodes = 1;
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				traversedNodes += dfs(adjacent, graph, color);
			}
		}
		color[source] = 2;
		return traversedNodes;
	}

	public static void main(String[] args) {
		int vertices = 10;
		int[][] edges = new int[][] { { 0, 2 }, { 0, 3 }, { 0, 6 }, { 1, 4 }, { 1, 8 }, { 2, 5 }, { 3, 7 }, { 3, 8 },
				{ 4, 8 }, { 5, 6 }, { 6, 2 }, { 7, 9 }, { 8, 0 }, { 9, 7 } };
//		int[][] edges = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 2 } };
		System.out.println(new Problem22_5_7().isGraphSemiconnected(vertices, edges));
	}

	class Vertex {
		int id;
		int finishingTime;

		public Vertex(int _id, int _finishtime) {
			this.id = _id;
			this.finishingTime = _finishtime;
		}
	}
}
