package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import auxiliaryMethods.CommonMethods;
import heap.Heap;
import heap.MinHeapOperations;

public class SingleSourceShortestPaths {
	/**
	 * This is Bellman ford algorithm implementation for shortest path in the graph.
	 * It returns true if there doesn't exist any reachable negative weight cycle in
	 * the graph.
	 * 
	 * @param g
	 * @param shortestPathTree It fills this array with shortest path tree
	 *                         information. shortestpathTree[i] is the parent of i
	 *                         in shortest path to i.
	 * @return
	 */
	public static boolean shortestPathByBellmanFord(Graph g, int[] shortestPathTree, int source) {
		if (g == null || source <= 0 || source > g.getNvertices())
			return false;
		int vertices = g.getNvertices();
		EdgeNode[] edges = g.getEdges();
		Map<Integer, VertexWeight> vertexToWeightMap = new HashMap<>();
		initialize(vertexToWeightMap, source, vertices);
		for (int i = 1; i < vertices; i++) {
			for (EdgeNode edgeList : edges) {
				EdgeNode adjacentList = edgeList;
				while (adjacentList != null) {
					boolean updated = relaxation(adjacentList, vertexToWeightMap);
					if (updated)
						shortestPathTree[adjacentList.getY()] = adjacentList.getX();
					adjacentList = adjacentList.getNext();
				}
			}
		}

		for (EdgeNode edgeList : edges) {
			EdgeNode adjacentList = edgeList;
			while (adjacentList != null) {
				boolean updated = relaxation(adjacentList, vertexToWeightMap);
				if (updated)
					return false;
				adjacentList = adjacentList.getNext();
			}
		}
		return true;
	}

	/**
	 * This is shortest path algorithm for the DAG. if graph is not DAG its behavior
	 * is unexpected. It returns shortest path tree array a where a[i] is the parent
	 * of i in shortest path from source to destination.
	 * 
	 * @param g
	 * @return
	 */
	public static int[] shortestPathInDAG(Graph g) {
		if (g == null || !g.isDirected())
			return null;
		int vertices = g.getNvertices();
		int[] shortestPathTree = new int[vertices + 1];
		Stack<Integer> topologicalSort = TopologicalSort.topologicalSort(g);
		Map<Integer, VertexWeight> vertexToWeightMap = new HashMap<>();
		initialize(vertexToWeightMap, topologicalSort.peek(), vertices);
		EdgeNode[] edges = g.getEdges();
		while (!topologicalSort.isEmpty()) {
			int node = topologicalSort.pop();
			EdgeNode adjacentList = edges[node];
			while (adjacentList != null) {
				if (relaxation(adjacentList, vertexToWeightMap))
					shortestPathTree[adjacentList.getY()] = adjacentList.getX();
				adjacentList = adjacentList.getNext();
			}
		}
		return shortestPathTree;
	}

	private static boolean relaxation(EdgeNode edge, Map<Integer, VertexWeight> vertexToWeightMap) {
		boolean updated = false;
		if (edge != null && vertexToWeightMap != null) {
			int vertexU = edge.getX(), vertexV = edge.getY();
			int newDistance = edge.getWeight() + vertexToWeightMap.get(vertexU).weight;
			VertexWeight vertexVWithWeight = vertexToWeightMap.get(vertexV);
			if (vertexVWithWeight.weight > newDistance) {
				vertexVWithWeight.weight = newDistance;
				updated = true;
			}
		}
		return updated;
	}

	private static void initialize(Map<Integer, VertexWeight> vertexToWeightMap, int source, int vertexCount) {
		for (int i = 1; i <= vertexCount; i++) {
			if (i == source)
				vertexToWeightMap.put(i, new VertexWeight(i, 0));
			else
				vertexToWeightMap.put(i, new VertexWeight(i, Integer.MAX_VALUE));
		}
	}

	/**
	 * Dijkstra shortest path implementation with the help of MinHeap. It returns
	 * shortest path tree in the form of array A where A[i] is parent of the vertex
	 * i in the shortest path from source s to i.
	 * 
	 * @param g
	 * @param source
	 * @return
	 */
	public static int[] dijkstraShortestPath(Graph g, int source) {
		if (g == null || source <= 0 || source > g.getNvertices())
			return null;
		int vertices = g.getNvertices();
		int[] shortestPathTree = new int[vertices + 1];
		EdgeNode[] edges = g.getEdges();
		MinHeapOperations<VertexWeight> heapOperations = new MinHeapOperations<>();
		VertexWeight[] vertexArray = getVertexWeightInitialized(vertices, source);
		Heap<VertexWeight> heap = heapOperations.makeHeap(vertexArray);
		while (!heap.isEmpty()) {
			VertexWeight vertex = heapOperations.extractMin(heap);
			EdgeNode adjacentList = edges[vertex.vertex];
			while (adjacentList != null) {
				VertexWeight adjacentVertex = vertexArray[adjacentList.getY() - 1];
				// get index of adjacent vertex in heap
				int index = heap.getIndex(adjacentVertex);
				int newWeight = vertex.weight + adjacentList.getWeight();
				// Relaxation Operation
				if (newWeight < adjacentVertex.weight) {
					adjacentVertex.weight = newWeight;
					heapOperations.decreaseKey(heap, index, adjacentVertex);
					shortestPathTree[adjacentVertex.vertex] = vertex.vertex;
				}
				adjacentList = adjacentList.getNext();
			}
		}
		return shortestPathTree;
	}

	/**
	 * Initialize vertex array with object VertexWeight. It would initialize every
	 * vertex's weight property with infinity except the source vertex.
	 * 
	 * @param vertices
	 * @param source
	 * @return
	 */
	private static VertexWeight[] getVertexWeightInitialized(int vertices, int source) {
		VertexWeight[] vertexWeight = new VertexWeight[vertices];
		for (int i = 1; i <= vertices; i++) {
			if (i == source)
				vertexWeight[i - 1] = new VertexWeight(i, 0);
			else
				vertexWeight[i - 1] = new VertexWeight(i, Integer.MAX_VALUE);

		}
		return vertexWeight;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readWeightedGraph(g, true);
		int[] shortestPathTree = new int[g.getNvertices() + 1];
		boolean pathExist = shortestPathByBellmanFord(g, shortestPathTree, 1);
		if (pathExist)
			CommonMethods.display(shortestPathTree);
		else
			System.out.println("Path has reachable negative weight cycle.");

		shortestPathTree = shortestPathInDAG(g);
		if (pathExist)
			CommonMethods.display(shortestPathTree);
		else
			System.out.println("Path has reachable negative weight cycle.");

		shortestPathTree = dijkstraShortestPath(g, 1);
		if (pathExist)
			CommonMethods.display(shortestPathTree);
		else
			System.out.println("Path has reachable negative weight cycle.");
	}
}
