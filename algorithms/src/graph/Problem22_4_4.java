package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Another way to perform topological sorting on a directed acyclic graph G(V,
 * E) is to repeatedly find a vertex of in-degree 0, output it, and remove it
 * and all of its outgoing edges from the graph. Explain how to implement this
 * idea so that it runs in time O(V+E). What happens to this algorithm if G has
 * cycles?
 * 
 * @author rajan-c
 *
 */
public class Problem22_4_4 {
	public static List<Integer> topologicalSort(Graph g) {
		List<Integer> topologicalSort = new ArrayList<>();
		if (g != null) {
			Set<Integer> deleted = new HashSet<>();
			int vertices = g.getNvertices();
			EdgeNode[] edgeNodeList = g.getEdges();
			int[] indegree = new int[vertices + 1];
			for (int i = 1; i <= vertices; i++)
				indegree[i] = g.indegree(i);
			while (deleted.size() < vertices) {
				int zeroIndegreeVertex = getIndegreeZeroVertex(indegree);
				if (zeroIndegreeVertex >= 1) {
					deleted.add(zeroIndegreeVertex);
					topologicalSort.add(zeroIndegreeVertex);
					EdgeNode adjacencyList = edgeNodeList[zeroIndegreeVertex];
					while (adjacencyList != null) {
						int y = adjacencyList.getY();
						indegree[y] -= 1;
						adjacencyList = adjacencyList.getNext();
					}
					indegree[zeroIndegreeVertex] -= 1;
				} else {
					System.out.println("No topological sort of vertices possible!");
					topologicalSort.clear();
					return topologicalSort;
				}
			}
		}
		return topologicalSort;
	}

	private static int getIndegreeZeroVertex(int[] indegrees) {
		for (int i = 1; i < indegrees.length; i++)
			if (indegrees[i] == 0)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readGraph(g, true);
		System.out.println(topologicalSort(g));
	}
}
