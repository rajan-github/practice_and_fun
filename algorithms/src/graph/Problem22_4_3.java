package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Give an algorithm that determines whether or not a given undirected graph
 * G(V,E) contains a cycle. Your algorithm should run in O(V) time, independent
 * of O(E).
 * 
 * @author rajan-c
 *
 */
public class Problem22_4_3 {

	public static boolean doesContainCycle(Graph g) {
		if (g == null)
			return false;
		Set<Integer> visited = new HashSet<>();
		int vertices = g.getNvertices();
		int[] parents = new int[vertices + 1];
		for (int i = 1; i <= vertices; i++)
			if (!visited.contains(i)) {
				visited.add(i);
				if (dfs(g, i, visited, parents))
					return true;
			}
		return false;
	}

	private static boolean dfs(Graph g, int source, Set<Integer> visited, int[] parents) {
		EdgeNode[] edgeList = g.getEdges();
		EdgeNode adjacencyList = edgeList[source];
		while (adjacencyList != null) {
			int y = adjacencyList.getY();
			if (visited.contains(y) && parents[source] != y)
				return true;
			else if (!visited.contains(y)) {
				visited.add(y);
				parents[y] = source;
				dfs(g, y, visited, parents);
			}
			adjacencyList = adjacencyList.getNext();
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readGraph(g, false);
		System.out.println(doesContainCycle(g));

	}
}
