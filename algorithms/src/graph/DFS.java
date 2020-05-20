package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import auxiliaryMethods.CommonMethods;

/**
 * DFS algorithm implementation for the adjacency list based graphs. This also
 * computes discovery time, finishing time and trees in the forest of the dfs
 * search.
 * 
 * @author rajan-c
 *
 */
public class DFS {

	private int time = 0;

	/**
	 * @param g
	 * @param d      discovery time
	 * @param f      finishing time
	 * @param parent parent of the node
	 */
	public void dfs(Graph g, int[] d, int[] f, int[] parent) {
		if (g == null)
			return;
		int vertices = g.getNvertices();
		Set<Integer> visited = new HashSet<>();
		for (int vertex = 1; vertex <= vertices; vertex++) {
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				dfsVisit(g, vertex, d, f, parent, visited);
			}

		}
	}

	private void dfsVisit(Graph g, int source, int[] d, int[] f, int[] parent, Set<Integer> visited) {
		time += 1;
		d[source] = time;
		EdgeNode[] edgeList = g.getEdges();
		EdgeNode adjacencyList = edgeList[source];
		while (adjacencyList != null) {
			int y = adjacencyList.getY();
			if (!visited.contains(y)) {
				visited.add(y);
				parent[y] = source;
				dfsVisit(g, y, d, f, parent, visited);
			}
			adjacencyList = adjacencyList.getNext();
		}
		time += 1;
		f[source] = time;
	}

	public void dfsStack(Graph g, int[] d, int[] f, int[] parent) {
		if (g == null)
			return;
		int vertices = g.getNvertices();
		Set<Integer> visited = new HashSet<>();
		for (int vertex = 1; vertex <= vertices; vertex++) {
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				dfsVisitStack(g, vertex, d, f, parent, visited);
			}

		}
	}

	private void dfsVisitStack(Graph g, int source, int[] d, int[] f, int[] parent, Set<Integer> visited) {
		Stack<Integer> stack = new Stack<>(), stackForFinishingOrder = new Stack<>();
		stack.add(source);
		EdgeNode[] edgeList = g.getEdges();
		visited.add(source);
		time = time + 1;
		d[source] = time;
		while (!stack.isEmpty()) {
			int node = stack.pop();
			EdgeNode adjacencyList = edgeList[node];
			while (adjacencyList != null) {
				int y = adjacencyList.getY();
				if (!visited.contains(y)) {
					visited.add(y);
					time = time + 1;
					d[y] = time;
					parent[y] = node;
					stack.push(y);
				}
				adjacencyList = adjacencyList.getNext();
			}
			stackForFinishingOrder.add(node);
		}
		while (!stackForFinishingOrder.isEmpty()) {
			time = time + 1;
			f[stackForFinishingOrder.pop()] = time;
		}
	}

	/**
	 * It assigns to each vertex � an integer label �:cc between 1 and k, where k is
	 * the number of connected components of G, such that u:cc D �:cc if and only if
	 * u and � are in the same connected component.
	 * 
	 * @param g
	 * @return
	 */
	public int[] connectedComponents(Graph g) {
		if (g == null)
			return null;
		int vertices = g.getNvertices();
		int[] connectedComponents = new int[vertices + 1];
		Set<Integer> visited = new HashSet<>();
		int componentNumber = 0;
		for (int vertex = 1; vertex <= vertices; vertex++) {
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				componentNumber += 1;
				dfsVisit(g, vertex, connectedComponents, componentNumber, visited);
			}

		}
		return connectedComponents;
	}

	private void dfsVisit(Graph g, int source, int[] connectedComp, int componentNumber, Set<Integer> visited) {
		connectedComp[source] = componentNumber;
		EdgeNode[] edgeList = g.getEdges();
		EdgeNode adjacencyList = edgeList[source];
		while (adjacencyList != null) {
			int y = adjacencyList.getY();
			if (!visited.contains(y)) {
				visited.add(y);
				dfsVisit(g, y, connectedComp, componentNumber, visited);
			}
			adjacencyList = adjacencyList.getNext();
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph();
		Graphs.readGraph(g, true);
//		int vertices = g.getNvertices();
//		int[] d = new int[vertices + 1];
//		int[] f = new int[vertices + 1];
//		int[] parent = new int[vertices + 1];
//		new DFS().dfsStack(g, d, f, parent);

		System.out.println("discovery time, finishing times, parents");
//		CommonMethods.display(d);
//		CommonMethods.display(f);
//		CommonMethods.display(parent);
		int[] cc = new DFS().connectedComponents(g);
		CommonMethods.display(cc);
	}

}
