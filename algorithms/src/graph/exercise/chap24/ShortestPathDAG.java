package graph.exercise.chap24;

import java.util.Arrays;
import java.util.Stack;

import graph.EdgeNode;
import graph.Graph;
import graph.Graphs;

/**
 * Shortest path in DAG.
 * 
 * @author rajan-c
 *
 */
public class ShortestPathDAG {
	public static int[] shortestPathDAG(Graph g, int source) {
		if (g == null)
			return new int[] {};
		int vertices = g.getNvertices();
		int[] parent = new int[vertices + 1];
		int[] weights = new int[vertices + 1];
		for (int i = 0; i < weights.length; i++)
			weights[i] = Integer.MAX_VALUE;
		EdgeNode[] edgeList = g.getEdges();
		Stack<Integer> topologicalOrder = toplologicalOrder(g);
		weights[topologicalOrder.peek()] = 0;
		while (!topologicalOrder.isEmpty()) {
			int vertex = topologicalOrder.pop();
			EdgeNode adjacent = edgeList[vertex];
			while (adjacent != null) {
				int y = adjacent.getY();
				int newWeight = weights[vertex] + adjacent.getWeight();
				if (newWeight < weights[y]) {
					parent[y] = vertex;
					weights[y] = newWeight;
				}
				adjacent = adjacent.getNext();
			}
		}
		return parent;
	}

	private static Stack<Integer> toplologicalOrder(Graph g) {
		int vertices = g.getNvertices();
		Stack<Integer> topologicalOrder = new Stack<>();
		int[] color = new int[vertices + 1];

		for (int i = 1; i <= vertices; i++)
			if (color[i] == 0)
				dfs(g, i, color, topologicalOrder);
		return topologicalOrder;
	}

	private static void dfs(Graph g, int source, int[] color, Stack<Integer> topologicalOrder) {
		EdgeNode[] adjacencyArray = g.getEdges();
		color[source] = 1;
		EdgeNode adjacencyList = adjacencyArray[source];
		while (adjacencyList != null) {
			int y = adjacencyList.getY();
			if (color[y] == 0) {
				color[y] = 1;
				dfs(g, y, color, topologicalOrder);
			}
			adjacencyList = adjacencyList.getNext();
		}
		color[source] = 2;
		topologicalOrder.add(source);
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.setDirected(true);
		Graphs.readWeightedGraph(g, g.isDirected());
		int[] parentGraph = shortestPathDAG(g, 1);
		System.out.println(Arrays.toString(parentGraph));
	}
}
