package practice.graph.spanningTree;

import java.util.Arrays;

import practice.graph.tree.disjointSets.DisjointSet;

public class MinSpanningTreeByKruskal {
	/**
	 * Each edge is represented as [x, y, w] means edge is from x to y and has
	 * weight w. Assuming total weight of the minimum-spanning tree is positive.
	 * 
	 * @param n
	 * @param edges
	 * @param parent
	 * @return
	 */
	public static int minimumSpanningTree(int n, int[][] edges) {
		if (edges.length < n - 1)
			return -1;
		Arrays.sort(edges, (int[] x, int[] y) -> Integer.compare(x[2], y[2]));
		DisjointSet disjointSet = new DisjointSet();
		for (int i = 0; i < n; i++)
			disjointSet.makeSet(i);
		int spanningTreeWeight = 0;
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			if (disjointSet.findSet(x) != disjointSet.findSet(y)) {
				disjointSet.union(x, y);
				spanningTreeWeight += edge[2];
			}
		}
		return spanningTreeWeight;
	}

	public static void main(String[] args) {
		int vertices = 9;
		int[][] edges = new int[][] { { 0, 1, 4 }, { 0, 7, 8 }, { 1, 0, 4 }, { 1, 7, 11 }, { 1, 2, 8 }, { 2, 1, 8 },
				{ 2, 8, 2 }, { 2, 3, 7 }, { 2, 5, 4 }, { 3, 2, 7 }, { 3, 5, 14 }, { 3, 4, 9 }, { 4, 3, 9 },
				{ 4, 5, 10 }, { 5, 6, 2 }, { 5, 2, 4 }, { 5, 3, 14 }, { 6, 8, 6 }, { 6, 7, 1 }, { 6, 5, 2 },
				{ 7, 1, 11 }, { 7, 8, 7 }, { 7, 0, 8 }, { 8, 2, 2 }, { 8, 7, 7 }, { 8, 6, 6 } };

		int weight = minimumSpanningTree(vertices, edges);
		System.out.println(weight);
	}
}
