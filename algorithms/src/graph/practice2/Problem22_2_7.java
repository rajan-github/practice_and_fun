package graph.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem22_2_7 {
	public static int[] paintWreslers(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.putIfAbsent(y, new ArrayList<>());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		int[] paint = new int[n];
		int[] visited = new int[n];
		int source = 0;
		paint[source] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty()) {
			Integer node = queue.remove();
			List<Integer> adjacents = graph.getOrDefault(node, new ArrayList<>());
			for (int adjacent : adjacents) {
				if (paint[node] == paint[adjacent] && paint[node] != 0)
					return null;
				else if (paint[node] == 1)
					paint[adjacent] = 2;
				else if (paint[node] == 2)
					paint[adjacent] = 1;
				if (visited[adjacent] == 0) {
					queue.add(adjacent);
					visited[adjacent] = 1;
				}

			}
		}
		return paint;
	}

	public static void main(String[] args) {
		int[] colors = paintWreslers(4, new int[][] { { 0, 2 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 } });
		System.out.println(Arrays.toString(colors));

		colors = paintWreslers(4, new int[][] { { 0, 2 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 } });
		System.out.println(Arrays.toString(colors));
	}
}
