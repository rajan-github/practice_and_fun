package practice.graph.spanningTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumSpanningTreeByPrims {
	public static Integer minimumSpanningTree(int vertices, int[][] edges) {
		if (edges.length < vertices - 1)
			return null;
		int minimumWeight = 0;
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.get(x).add(new int[] { y, edge[2] });
		}
		return minimumWeight;
	}
}

class Vertex {
	int id;
	int weight;

	public Vertex(int id, int weight) {
		this.id = id;
		this.weight = weight;
	}
}
