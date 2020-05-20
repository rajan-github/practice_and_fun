package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * This class implements the topological sort algorithm. Topological sort is
 * applicable only on directed acyclic graphs. Algorithm assumes that graph
 * doesn't have any cycles.
 * 
 * @author rajan-c
 *
 */
public class TopologicalSort {

	public static Stack<Integer> topologicalSort(Graph g) {
		Stack<Integer> stack = new Stack<>();
		if (g != null)
			dfs(g, stack);
		return stack;
	}

	private static void dfs(Graph g, Stack<Integer> stack) {
		int vertices = g.getNvertices();
		Set<Integer> visited = new HashSet<>();
		for (int source = 1; source <= vertices; source++) {
			if (!visited.contains(source)) {
				dfsVisit(g, source, visited, stack);
				visited.add(source);
			}
		}
	}

	private static void dfsVisit(Graph g, int source, Set<Integer> visited, Stack<Integer> stack) {
		EdgeNode[] edgeList = g.getEdges();
		EdgeNode adjacencyList = edgeList[source];
		while (adjacencyList != null) {
			int y = adjacencyList.getY();
			if (!visited.contains(y)) {
				visited.add(y);
				dfsVisit(g, y, visited, stack);
			}
			adjacencyList = adjacencyList.getNext();
		}
		stack.add(source);
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readGraph(g, true);
		Stack<Integer> stack = topologicalSort(g);
		while (!stack.isEmpty())
			System.out.print(stack.pop() + "> ");
	}
}
