package graph.exercise.chap24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import graph.EdgeNode;
import graph.Graph;
import graph.Graphs;

public class ShortestPath {
	public static int[] shortestPathByBellmanFord(Graph g, int source) {
		if (g == null)
			return null;
		int vertices = g.getNvertices();
		int[] parents = new int[vertices + 1];
		for (int i = 0; i < parents.length; i++)
			parents[i] = -1;
		EdgeNode[] edges = g.getEdges();
		Map<Integer, Long> vertexToWeightMap = new HashMap<>();
		initialize(vertexToWeightMap, source, vertices);

		for (int i = 1; i <= vertices; i++) {
			EdgeNode adjacencyList = edges[i];
			while (adjacencyList != null) {
				int x = adjacencyList.getX(), y = adjacencyList.getY();
				long newWeight = vertexToWeightMap.get(x) + adjacencyList.getWeight();
				if (newWeight < vertexToWeightMap.get(y)) {
					vertexToWeightMap.put(y, newWeight);
					parents[y] = x;
				}
				adjacencyList = adjacencyList.getNext();
			}
		}
		for (int i = 1; i <= vertices; i++) {
			EdgeNode edgeList = edges[i];
			while (edgeList != null) {
				int x = edgeList.getX(), y = edgeList.getY();
				if (vertexToWeightMap.get(y) > vertexToWeightMap.get(x) + edgeList.getWeight())
					return null;
				edgeList = edgeList.getNext();
			}
		}
		return parents;
	}

	private static void initialize(Map<Integer, Long> vertexToWeightMap, int source, int vertices) {
		for (int i = 1; i <= vertices; i++)
			vertexToWeightMap.put(i, (long) Integer.MAX_VALUE);
		vertexToWeightMap.put(source, 0L);
	}

	public int[] dijkstraAlgorithm() {
		return null;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readWeightedGraph(g, true);
		int[] path = shortestPathByBellmanFord(g, 1);
		System.out.println(Arrays.toString(path));
	}
}
