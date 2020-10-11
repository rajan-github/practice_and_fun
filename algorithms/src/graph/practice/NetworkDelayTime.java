package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * @author rajan-c
 *
 */
public class NetworkDelayTime {
	public static int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
		int[][] adjacencyMatrix = new int[N + 1][N + 1];

		long[] distances = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			distances[i] = Integer.MAX_VALUE;
			adjacencyMap.put(i, new HashSet<>());
		}

		for (int[] edge : times) {
			int x = edge[0], y = edge[1];
			adjacencyMatrix[x][y] = edge[2];
			adjacencyMap.get(x).add(y);
		}

		Set<Integer> processed = new HashSet<>();
		Set<Integer> vertexSet = new HashSet<>();
		vertexSet.add(K);
		processed.add(K);
		distances[K] = 0;
		while (!vertexSet.isEmpty()) {
			int node = extractMin(vertexSet, distances);
			processed.add(node);
			Set<Integer> adjacents = adjacencyMap.get(node);
			for (int adjacent : adjacents) {
				if (!processed.contains(adjacent)) {
					distances[adjacent] = Math.min(distances[adjacent],
							distances[node] + adjacencyMatrix[node][adjacent]);
					vertexSet.add(adjacent);
				}
			}
		}
		long delay = -1;
		for (int i = 1; i <= N; i++)
			if (distances[i] == -1)
				return -1;
			else
				delay = Math.max(delay, distances[i]);
		return (int) (delay >= Integer.MAX_VALUE ? -1 : delay);
	}

	private static int extractMin(Set<Integer> vertexSet, long[] distances) {
		int min = vertexSet.iterator().next();
		for (int vertex : vertexSet)
			if (distances[vertex] < distances[min])
				min = vertex;
		vertexSet.remove(min);
		return min;
	}

	public static void main(String[] args) {

		System.out.println(networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2));

	}
}
