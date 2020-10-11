package practice.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem24_3_6 {
	public static int[] mostReliablePath(int vertices, double[][] edges, int source, int destination) {
		Map<Integer, List<double[]>> graph = new HashMap<>();
		for (double[] edge : edges) {
			graph.putIfAbsent((int) edge[0], new ArrayList<>());
			graph.get((int) edge[0]).add(new double[] { edge[1], edge[2] });

			graph.putIfAbsent((int) edge[1], new ArrayList<>());
			graph.get((int) edge[1]).add(new double[] { edge[0], edge[2] });
		}

		double[] weights = new double[vertices];
		int[] parents = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			weights[i] = Integer.MIN_VALUE;
			parents[i] = -1;
		}
		weights[source] = 1;
		Set<Integer> usedIndexes = new HashSet<>();
		while (usedIndexes.size() < vertices) {
			int maxIndex = findMax(weights, usedIndexes);
			if (maxIndex < 0)
				return null;
			usedIndexes.add(maxIndex);
			List<double[]> adjacents = graph.getOrDefault(maxIndex, new ArrayList<>());
			for (double[] adjacent : adjacents) {
				int adjacentIndex = (int) adjacent[0];
				if (usedIndexes.contains(adjacentIndex))
					continue;
				if (weights[adjacentIndex] < (weights[maxIndex] * adjacent[1])) {
					weights[adjacentIndex] = weights[maxIndex] * adjacent[1];
					parents[adjacentIndex] = maxIndex;
				}
			}
		}
		System.out.println(weights[destination] == Integer.MIN_VALUE ? 0 : weights[destination]);
		return parents;
	}

	private static int findMax(double[] weights, Set<Integer> usedIndexes) {
		int maxIndex = -1;
		for (int index = 0; index < weights.length; index++) {
			if (!usedIndexes.contains(index) && (maxIndex < 0 || weights[index] > weights[maxIndex]))
				maxIndex = index;
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int vertices = 3;
		double[][] edges = new double[][] { { 0, 1, 0.5 }, { 0, 2, 0.3 }, { 1, 2, 0.5 } };

		int[] parents = mostReliablePath(vertices, edges, 0, 2);
//		System.out.println(Arrays.toString(parents));

		System.out.println("-------New graph------");
		vertices = 3;
		edges = new double[][] { { 0, 1, 0.5 } };

		parents = mostReliablePath(vertices, edges, 0, 2);
//		System.out.println(Arrays.toString(parents));

		System.out.println("------New graph-------");
		vertices = 5;
		edges = new double[][] { { 1, 4, 0.37 }, { 2, 4, 0.17 }, { 0, 4, 0.93 }, { 0, 3, 0.23 }, { 0, 2, 0.39 },
				{ 2, 3, 0.04 } };
		parents = mostReliablePath(vertices, edges, 3, 4);

		System.out.println("------New graph-------");
		vertices = 3;
		edges = new double[][] { { 0, 1, 0.5 } };
		parents = mostReliablePath(vertices, edges, 0, 2);

		System.out.println(Arrays.toString(parents));

	}

}
