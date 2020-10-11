package graph.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem22_5_2 {
	private int time = 0;

	public List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
		List<List<Integer>> connectedComponents = new ArrayList<>();
		if (n <= 0)
			return connectedComponents;

		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
		}

		PriorityQueue<Vertex> finishingTimes = new PriorityQueue<>(
				(Vertex x, Vertex y) -> Integer.compare(y.finishTime, x.finishTime));

		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				dfs(i, graph, color, finishingTimes);
			}
		}

		int[] color2 = new int[n];
		Map<Integer, List<Integer>> transpose = transpose(graph);
		while (!finishingTimes.isEmpty()) {
			Vertex node = finishingTimes.remove();
			if (color2[node.id] == 0) {
				color2[node.id] = 1;
				List<Integer> component = new ArrayList<>();
				dfs(node.id, transpose, color2, component);
				connectedComponents.add(component);
			}
		}
		return connectedComponents;
	}

	private void dfs(int source, Map<Integer, List<Integer>> graph, int[] color, PriorityQueue<Vertex> finishingTimes) {
		time += 1;
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				dfs(adjacent, graph, color, finishingTimes);
			}
		}
		color[source] = 2;
		time += 1;
		finishingTimes.add(new Vertex(source, time));
	}

	private void dfs(int source, Map<Integer, List<Integer>> graph, int[] color, List<Integer> tree) {
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				dfs(adjacent, graph, color, tree);
			}
		}
		color[source] = 2;
		tree.add(source);
	}

	private Map<Integer, List<Integer>> transpose(Map<Integer, List<Integer>> graph) {
		Map<Integer, List<Integer>> transpose = new HashMap<>();
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			List<Integer> adjacents = entry.getValue();
			for (Integer adjacent : adjacents) {
				transpose.putIfAbsent(adjacent, new ArrayList<>());
				transpose.get(adjacent).add(entry.getKey());
			}
		}
		return transpose;
	}

	class Vertex {
		int id;
		int finishTime;

		public Vertex(int _id, int _finishTime) {
			this.id = _id;
			this.finishTime = _finishTime;
		}

		@Override
		public String toString() {
			return "Vertex [id=" + id + ", finishTime=" + finishTime + "]";
		}

	}

	public static void main(String[] args) {
		int vertices = 10;
		int[][] edges = new int[][] { { 0, 2 }, { 0, 3 }, { 0, 6 }, { 1, 4 }, { 1, 8 }, { 2, 5 }, { 3, 7 }, { 3, 8 },
				{ 4, 8 }, { 5, 6 }, { 6, 2 }, { 7, 9 }, { 8, 0 }, { 9, 7 } };

		List<List<Integer>> scc = new Problem22_5_2().stronglyConnectedComponents(vertices, edges);
		System.out.println(scc);

	}
}
