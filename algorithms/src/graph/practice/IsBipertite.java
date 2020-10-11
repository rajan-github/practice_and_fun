package graph.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split it's set of nodes into two
 * independent subsets A and B such that every edge in the graph has one node in
 * A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for
 * which the edge between nodes i and j exists. Each node is an integer between
 * 0 and graph.length - 1. There are no self edges or parallel edges: graph[i]
 * does not contain i, and it doesn't contain any element twice.
 * 
 * @author rajan-c
 *
 */
public class IsBipertite {
	public static boolean isBipartite(int[][] graph) {
		if (graph != null && graph.length > 0) {
			Set<Integer> processed = new HashSet<>();
			for (int i = 0; i < graph.length; i++) {
				if (!processed.contains(i)) {
					if (!bfs(graph, processed, i))
						return false;
				}
			}

		}
		return true;
	}

	private static boolean bfs(int[][] graph, Set<Integer> processed, int source) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		processed.add(source);
		Set<Integer> redVertices = new HashSet<>(), blackVertices = new HashSet<>();
		redVertices.add(source);
		while (!queue.isEmpty()) {
			int node = queue.remove();
			int[] adjacents = graph[node];
			if (redVertices.contains(node)) {
				for (int adjacent : adjacents) {
					if (redVertices.contains(adjacent))
						return false;
					if (!processed.contains(adjacent)) {
						blackVertices.add(adjacent);
						queue.add(adjacent);
						processed.add(adjacent);
					}

				}
			} else {
				for (int adjacent : adjacents) {
					if (blackVertices.contains(adjacent))
						return false;
					if (!processed.contains(adjacent)) {
						processed.add(adjacent);
						redVertices.add(adjacent);
						queue.add(adjacent);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } }));
		System.out.println(isBipartite(new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } }));
		System.out.println(isBipartite(new int[][] { {}, { 2, 4, 6 }, { 1, 4, 8, 9 }, { 7, 8 }, { 1, 2, 8, 9 },
				{ 6, 9 }, { 1, 5, 7, 8, 9 }, { 3, 6, 9 }, { 2, 3, 4, 6, 9 }, { 2, 4, 5, 6, 7, 8 } }));
	}
}
