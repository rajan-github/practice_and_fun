package graph.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonMethods {
	public static Map<Integer, List<Integer>> createGraph(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.get(x).add(y);
		}
		return graph;
	}
}
