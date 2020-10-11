package graph.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Compute articulation points in connected undirected graph.
 * 
 * @author rajan-c
 *
 */
public class Problem22_2_d {
	private int time = 0;

	public Set<Integer> articulationPoints(int n, int[][] edges) {
		Set<Integer> articulationPoints = new HashSet<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
		}

		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		int[] color = new int[n];
		int[] discoveryTime = new int[n];
		int[] lowTime = new int[n];
		int[] childCount = new int[n];

		color[0] = 1;
		dfs(0, graph, parent, color, discoveryTime, lowTime, childCount);

		for (int i = 0; i < n; i++)
			if (parent[i] >= 0)
				childCount[parent[i]] += 1;

		System.out.println(Arrays.toString(discoveryTime));
//		System.out.println(Arrays.toString(finishTime));
		System.out.println(Arrays.toString(lowTime));
//		System.out.println(Arrays.toString(childCount));

		for (int i = 0; i < n; i++) {
			if (parent[i] >= 0 && childCount[i] > 0)
				articulationPoints.add(i);

			if (childCount[i] > 1) {
				// check if node i has more than one child in dfs tree.
				articulationPoints.add(i);
			}
		}
		return articulationPoints;
	}

	private void dfs(int source, Map<Integer, List<Integer>> graph, int[] parent, int[] color, int[] discoveryTime,
			int[] lowTime, int[] childCount) {
		discoveryTime[source] = lowTime[source] = ++time;
		int child = 0;
		List<Integer> adjacents = graph.getOrDefault(source, new ArrayList<>());
		for (Integer adjacent : adjacents) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				parent[adjacent] = source;
				child++;
				dfs(adjacent, graph, parent, color, discoveryTime, lowTime, childCount);
			} else if (color[adjacent] == 1)
				lowTime[source] = Math.min(lowTime[adjacent], lowTime[source]);
		}
		++time;
		childCount[source] = child;
	}

	public static void main(String[] args) {
		int vertices = 15;
		int[][] edges = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 0, 2 }, { 2, 0 }, { 0, 3 }, { 3, 0 },
				{ 2, 3 }, { 3, 2 }, { 1, 3 }, { 3, 1 }, { 3, 4 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 5 }, { 6, 4 },
				{ 4, 6 }, { 4, 7 }, { 7, 4 }, { 7, 8 }, { 8, 7 }, { 8, 9 }, { 9, 8 }, { 8, 4 }, { 4, 8 }, { 4, 10 },
				{ 10, 4 }, { 10, 11 }, { 11, 10 }, { 10, 12 }, { 12, 10 }, { 11, 13 }, { 13, 11 }, { 12, 13 },
				{ 13, 12 }, { 13, 14 }, { 14, 13 }
//				, { 14, 15 }, { 15, 14 }, { 15, 16 }, { 16, 15 }, { 16, 17 },
//				{ 17, 16 }, { 16, 18 }, { 18, 16 } 
		};

		Set<Integer> articulationPoints = new Problem22_2_d().articulationPoints(vertices, edges);
		System.out.println(articulationPoints);
	}
}
