package graph.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * For an undirected graph with tree characteristics, we can choose any node as
 * the root. The result graph is then a rooted tree. Among all possible rooted
 * trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list
 * of their root labels.
 * 
 * Format The graph contains n nodes which are labeled from 0 to n - 1. You will
 * be given the number n and a list of undirected edges (each edge is a pair of
 * labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * @author rajan-c
 *
 */
public class MinimumHeightTrees {
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> minimumHeightTrees = new ArrayList<>();
		if (n == 0 || edges == null)
			return minimumHeightTrees;
		if (n == 1) {
			minimumHeightTrees.add(0);
			return minimumHeightTrees;
		}
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		Set<Integer> minimumHeightRoots = new HashSet<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<>());
			minimumHeightRoots.add(i);
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		Set<Integer> leaves = new HashSet<>();
		while (n > 2) {
			Iterator<Integer> iterator = minimumHeightRoots.iterator();
			leaves.clear();
			while (iterator.hasNext()) {
				int i = iterator.next();
				if (graph.get(i).size() == 1 && !leaves.contains(i))
					leaves.add(i);
			}
			for (int i : leaves) {
				minimumHeightRoots.remove(i);
				int adjacent = graph.get(i).iterator().next();
				graph.get(adjacent).remove(i);
				graph.remove(i);
			}
			n = n - leaves.size();
		}

		Iterator<Integer> iterator = minimumHeightRoots.iterator();
		while (iterator.hasNext())
			minimumHeightTrees.add(iterator.next());
		return minimumHeightTrees;
	}

	public static void main(String[] args) {
		System.out.println(findMinHeightTrees(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } }));
		System.out.println(findMinHeightTrees(6, new int[][] { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } }));

	}

}
