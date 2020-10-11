package practice.graph.shortestPath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BellManFord {
	public static boolean shortestPath(int vertices, int[][] edges, int[] tree) {
		Map<Integer, Long> weightMap = new HashMap<>();
		weightMap.put(0, 0L);
		for (int i = 1; i < vertices; i++) {
			for (int[] edge : edges) {
				int x = edge[0], y = edge[1];
				long weight = weightMap.getOrDefault(y, (long) Integer.MAX_VALUE);
				long newWeight = weightMap.getOrDefault(x, (long) Integer.MAX_VALUE) + edge[2];
				if (weight > newWeight) {
					weightMap.put(y, newWeight);
					tree[y] = x;
				}
			}
		}

		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			if (weightMap.getOrDefault(y,
					(long) Integer.MAX_VALUE) > weightMap.getOrDefault(x, (long) Integer.MAX_VALUE) + edge[2])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int vertices = 9;
		int[][] edges = new int[][] { { 0, 1, 4 }, { 0, 7, 8 }, { 1, 0, 4 }, { 1, 7, 11 }, { 1, 2, 8 }, { 2, 1, 8 },
				{ 2, 8, 2 }, { 2, 3, 7 }, { 2, 5, 4 }, { 3, 2, 7 }, { 3, 5, 14 }, { 3, 4, 9 }, { 4, 3, 9 },
				{ 4, 5, 10 }, { 5, 6, 2 }, { 5, 2, 4 }, { 5, 3, 14 }, { 6, 8, 6 }, { 6, 7, 1 }, { 6, 5, 2 },
				{ 7, 1, 11 }, { 7, 8, 7 }, { 7, 0, 8 }, { 8, 2, 2 }, { 8, 7, 7 }, { 8, 6, 6 } };

		int[] tree = new int[9];
		boolean exists = shortestPath(vertices, edges, tree);
		if (exists)
			System.out.println("Path exists: \n" + Arrays.toString(tree));
		else
			System.out.println("Doesn't exist.");
	}
}
