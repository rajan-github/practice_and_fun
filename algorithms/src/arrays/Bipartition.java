package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bipartition {
	public static boolean possibleBipartition(int N, int[][] dislikes) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] dislike : dislikes) {
			if (graph.containsKey(dislike[0]))
				graph.get(dislike[0]).add(dislike[1]);
			else {
				List<Integer> adjacentList = new ArrayList<>();
				adjacentList.add(dislike[1]);
				graph.put(dislike[0], adjacentList);
			}
		}

		Set<Integer> redColored = new HashSet<>(), blueColored = new HashSet<>();
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			int node = entry.getKey();
			if (redColored.contains(node)) {
				List<Integer> adjacencyList = entry.getValue();
				for (int vertex : adjacencyList) {
					if (redColored.contains(vertex))
						return false;
					blueColored.add(vertex);
				}

			} else if (blueColored.contains(node)) {
				List<Integer> adjacencyList = entry.getValue();
				for (int vertex : adjacencyList) {
					if (blueColored.contains(vertex))
						return false;
					redColored.add(vertex);
				}
			} else {
				redColored.add(node);
				List<Integer> adjacencyList = entry.getValue();
				for (int vertex : adjacencyList) {
					if (redColored.contains(vertex))
						return false;
					blueColored.add(vertex);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] dislikes = new int[][] { { 4, 7 }, { 4, 8 }, { 5, 6 }, { 1, 6 }, { 3, 7 }, { 2, 5 }, { 5, 8 }, { 1, 2 },
				{ 4, 9 }, { 6, 10 }, { 8, 10 }, { 3, 6 }, { 2, 10 }, { 9, 10 }, { 3, 9 }, { 2, 3 }, { 1, 9 }, { 4, 6 },
				{ 5, 7 }, { 3, 8 }, { 1, 8 }, { 1, 7 }, { 2, 4 } };

		System.out.println(possibleBipartition(10, dislikes));
		dislikes = new int[][] { { 4, 7 }, { 4, 8 }, { 2, 8 }, { 8, 9 }, { 1, 6 }, { 5, 8 }, { 1, 2 }, { 6, 7 },
				{ 3, 10 }, { 8, 10 }, { 1, 5 }, { 7, 10 }, { 1, 10 }, { 3, 5 }, { 3, 6 }, { 1, 4 }, { 3, 9 }, { 2, 3 },
				{ 1, 9 }, { 7, 9 }, { 2, 7 }, { 6, 8 }, { 5, 7 }, { 3, 4 } };
		System.out.println(possibleBipartition(10, dislikes));

		dislikes = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		System.out.println(possibleBipartition(3, dislikes));
	}

}
