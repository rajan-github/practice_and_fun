package practice.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.graph.Utilities;
import practice.graph.spanningTree.Heap;
import practice.graph.spanningTree.MinHeapOperations;

public class Problem24_3_1 {
	public static void shortestPath(int vertices, int[][] edges, int source, int[] parent, long[] weights) {
		Map<Integer, List<int[]>> graph = Utilities.makeGraph(edges);

		Map<Integer, Vertex> vertexMap = new HashMap<>();
		vertexMap.put(source, new Vertex(source, 0));
		parent[source] = -1;

		Heap<Vertex> minHeap = new Heap<>(vertices);

		for (int i = 0; i < vertices; i++) {
			Vertex temp = new Vertex(i, (i == source) ? 0 : Integer.MAX_VALUE);
			vertexMap.putIfAbsent(i, temp);
			MinHeapOperations.insert(temp, minHeap);
		}

		while (!minHeap.isEmpty()) {
			Vertex node = MinHeapOperations.extractMin(minHeap);
			List<int[]> adjacents = graph.getOrDefault(node.id, new ArrayList<>());

			for (int[] adjacent : adjacents) {
				Vertex adjacentNode = vertexMap.get(adjacent[0]);
				if (adjacentNode.weight > (node.weight + adjacent[1])) {
					adjacentNode.weight = node.weight + adjacent[1];
					MinHeapOperations.decreaseKey(minHeap, minHeap.getIndex(adjacentNode), adjacentNode);
					parent[adjacent[0]] = node.id;
					weights[adjacent[0]] = adjacentNode.weight;
				}
			}
		}
		System.out.println(Arrays.toString(parent));
		System.out.println(Arrays.toString(weights));
	}

	public static void main(String[] args) {
		int vertices = 5;
		int[][] edges = new int[][] { { 0, 1, 3 }, { 0, 2, 5 }, { 1, 3, 6 }, { 2, 1, 1 }, { 2, 4, 6 }, { 2, 3, 4 },
				{ 3, 4, 2 }, { 4, 3, 7 }, { 4, 0, 3 } };

		shortestPath(vertices, edges, 0, new int[vertices], new long[vertices]);
	}

}

class Vertex implements Comparable<Vertex> {
	int id;
	long weight;

	public Vertex(int _id, int _weight) {
		this.id = _id;
		this.weight = _weight;
	}

	@Override
	public int compareTo(Vertex arg0) {
		if (this.weight == arg0.weight)
			return 0;
		return weight > arg0.weight ? 1 : -1;
	}
}
