package graph.exercise.chap22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import auxiliaryMethods.CommonMethods;

/**
 * More precisely, show how to modify depth-first search so that it assigns to
 * each vertex u an integer label u:cc between 1 and k, where k is the number of
 * connected components of G, such that u:cc v.cc if and only if u and v are in
 * the same connected component.
 * 
 * @author rajan-c
 *
 */
public class CCInUndirectedGraph {
	/*
	 * Method returns an array of length n where array[i] is component number of the
	 * ith vertex.
	 */
	public static int[] connectedComponents(int[][] edges, int vertices) {
		Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();
		for (int i = 0; i < vertices; i++)
			adjacentMap.put(i, new HashSet<>());

		if (edges != null)
			for (int[] edge : edges) {
				adjacentMap.get(edge[0]).add(edge[1]);
				adjacentMap.get(edge[1]).add(edge[0]);
			}

		int[] connectedComponents = new int[vertices];
		int[] color = new int[vertices];
		int components = 0;
		for (int i = 0; i < vertices; i++) {
			if (color[i] == 0) {
				components++;
				dfs(adjacentMap, i, connectedComponents, color, components);

			}

		}
		return connectedComponents;
	}

	private static void dfs(Map<Integer, Set<Integer>> adjacencyMap, int src, int[] ccArray, int[] color,
			int componentNumber) {
		color[src] = 1;
		ccArray[src] = componentNumber;
		Set<Integer> adjacents = adjacencyMap.get(src);
		for (int adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				ccArray[adjacent] = componentNumber;
				dfs(adjacencyMap, adjacent, ccArray, color, componentNumber);
			}
		}
		color[src] = 2;
	}

	public static void main(String[] args) {
		int[] cc = connectedComponents(new int[][] { { 0, 1 }, { 0, 2 } }, 7);
//		CommonMethods.display(cc);

		cc = connectedComponents(new int[][] {}, 7);
		CommonMethods.display(cc);

		cc = connectedComponents(new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }, 3);
		CommonMethods.display(cc);
	}
}
