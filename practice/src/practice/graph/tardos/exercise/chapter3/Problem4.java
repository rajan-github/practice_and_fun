package practice.graph.tardos.exercise.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem4 {
	public static boolean isBipertite(int n, int[][] edges) {
		Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			adjacencyMap.putIfAbsent(x, new ArrayList<>());
			adjacencyMap.putIfAbsent(y, new ArrayList<>());
			adjacencyMap.get(x).add(y);
			adjacencyMap.get(y).add(x);
		}
		int[] color = new int[n];
		for (int i = 0; i < n; i++)
			if (color[i] == 0) {
				color[i] = 1;
				boolean canPartition = canPartition(n, i, adjacencyMap, color);
				if (!canPartition)
					return false;
			}
		return true;
	}

	private static boolean canPartition(int n, int source, Map<Integer, List<Integer>> adjacencyMap, int[] color) {
		int[] processed = new int[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		color[source] = 1;
		processed[source] = 1;
		while (!queue.isEmpty()) {
			Integer node = queue.remove();
			List<Integer> adjacents = adjacencyMap.getOrDefault(node, new ArrayList<>());
			for (Integer adjacent : adjacents) {
				if (color[node] == color[adjacent])
					return false;
				else if (color[node] == 1)
					color[adjacent] = 2;
				else
					color[adjacent] = 1;
				if (processed[adjacent] == 0) {
					processed[adjacent] = 1;
					queue.add(adjacent);
				}
			}
		}
		return true;
	}
}
