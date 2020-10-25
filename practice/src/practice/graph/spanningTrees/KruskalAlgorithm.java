package practice.graph.spanningTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import disjointsets.DisjointSetWithTree;

public class KruskalAlgorithm {
	public static int minSpanningWeight(int n, int[][] edges) {
		Arrays.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));
		DisjointSetWithTree disjointSets = new DisjointSetWithTree();
		for (int i = 0; i < n; i++)
			disjointSets.makeSet(i);

		int totalWeight = 0;
		List<int[]> spanningTree = new ArrayList<>();
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			if (disjointSets.findSet(x) != disjointSets.findSet(y)) {
				totalWeight += edge[2];
				spanningTree.add(edge);
				disjointSets.union(x, y);
			}
		}

		for (int[] edge : spanningTree)
			System.out.println(Arrays.toString(edge));

		return totalWeight;
	}

}
