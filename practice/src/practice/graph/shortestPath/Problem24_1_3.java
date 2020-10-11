package practice.graph.shortestPath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem24_1_3 {
	public static int[] shortestPath(int vertices, int[][] edges) {
		int[] tree = new int[vertices];
		Map<Integer, Long> weightMap = new HashMap<>();
		weightMap.put(0, 0L);
		boolean changed = false, firstIteration = true;
		while (firstIteration || changed) {
			firstIteration = false;
			changed = false;
			for (int[] edge : edges) {
				int x = edge[0], y = edge[1];
				long weight = weightMap.getOrDefault(y, (long) Integer.MAX_VALUE);
				long newWeight = weightMap.getOrDefault(x, (long) Integer.MAX_VALUE) + edge[2];
				if (weight > newWeight) {
					weightMap.put(y, newWeight);
					tree[y] = x;
					changed = true;
				}
			}
		}
		return tree;
	}

	public static void main(String[] args) {
		int vertices = 9;
		int[][] edges = new int[][] { { 0, 1, 4 }, { 0, 7, 8 }, { 1, 0, 4 }, { 1, 7, 11 }, { 1, 2, 8 }, { 2, 1, 8 },
				{ 2, 8, 2 }, { 2, 3, 7 }, { 2, 5, 4 }, { 3, 2, 7 }, { 3, 5, 14 }, { 3, 4, 9 }, { 4, 3, 9 },
				{ 4, 5, 10 }, { 5, 6, 2 }, { 5, 2, 4 }, { 5, 3, 14 }, { 6, 8, 6 }, { 6, 7, 1 }, { 6, 5, 2 },
				{ 7, 1, 11 }, { 7, 8, 7 }, { 7, 0, 8 }, { 8, 2, 2 }, { 8, 7, 7 }, { 8, 6, 6 } };

		int[] tree = shortestPath(vertices, edges);
		System.out.println("Path exists: \n" + Arrays.toString(tree));
	}
}
