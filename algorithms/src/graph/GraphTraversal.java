package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {
	public static List<Integer> bfsGraphOnList(Graph g, int source) {
		List<Integer> bfsTraversal = new ArrayList<>();
		if (g != null && g.getNvertices() >= source && source >= 1) {
			int vertices = g.getNvertices(), time = 0;
			int[] discoveryTime = new int[vertices + 1];
			Set<Integer> discoveredVertices = new HashSet<>();
			Queue<Integer> queue = new LinkedList<>();
			EdgeNode[] edgeList = g.getEdges();
			queue.add(source);
			queue.add(null);
			discoveredVertices.add(source);
			while (!queue.isEmpty()) {
				Integer vertex = queue.remove();
				if (vertex != null) {
					bfsTraversal.add(vertex);
					discoveryTime[vertex] = time;
					EdgeNode adjacencyList = edgeList[vertex];
					while (adjacencyList != null) {
						int y = adjacencyList.getY();
						if (!discoveredVertices.contains(y)) {
							queue.add(y);
							discoveredVertices.add(y);
						}
						adjacencyList = adjacencyList.getNext();
					}
				} else {
					time += 1;
					if (!queue.isEmpty())
						queue.add(null);
				}
			}
			System.out.println("Discovery time is: ");
			auxiliaryMethods.CommonMethods.display(discoveryTime);
		}
		return bfsTraversal;
	}

	public static List<Integer> bfsGraphOnMatrix(GraphWithArray g, int source) {
		List<Integer> bfsTraversal = new ArrayList<>();
		if (g != null && g.getVertex() >= source && source >= 1) {
			Queue<Integer> queue = new LinkedList<>();
			int vertices = g.getVertex(), time = 0;
			int[] discoveryTime = new int[vertices + 1];
			Set<Integer> discovered = new HashSet<>();
			queue.add(source);
			queue.add(null);
			discovered.add(source);
			int[][] adjacencyMatrix = g.getAdjacencyMatrix();
			while (!queue.isEmpty()) {
				Integer vertex = queue.remove();
				if (vertex != null) {
					discoveryTime[vertex] = time;
					bfsTraversal.add(vertex);
					int[] adjacencyList = adjacencyMatrix[vertex];
					for (int v : adjacencyList) {
						if (!discovered.contains(v)) {
							discovered.add(v);
							queue.add(v);
						}
					}
				} else {
					time += 1;
					if (!queue.isEmpty())
						queue.add(null);
				}
			}
		}
		return bfsTraversal;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readGraph(g, false);
		List<Integer> bfsTraversal = bfsGraphOnList(g, 3);
		System.out.println(bfsTraversal);
	}
}
