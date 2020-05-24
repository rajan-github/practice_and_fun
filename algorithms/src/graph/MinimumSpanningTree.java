package graph;

import heap.Heap;
import heap.MinHeapOperations;

public class MinimumSpanningTree {

	MinHeapOperations<VertexWeight> heapOperations = new MinHeapOperations<>();

	public void minSpanningTreeByKruskal(Graph g) {

	}

	class VertexWeight implements Comparable<VertexWeight> {
		int vertex;
		int weight;

		public VertexWeight(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(VertexWeight o) {
			if (o.weight > weight)
				return -1;
			else if (weight > o.weight)
				return 1;
			return 0;
		}
	}

	public void minSpanningTreeByPrim(Graph g) {
		if (g != null) {
			EdgeNode[] edges = g.getEdges();
			int source = 1, vertices = g.getNvertices();
			VertexWeight[] weightArray = new VertexWeight[vertices + 1];
			for (int i = 1; i <= vertices; i++)
				weightArray[i] = new VertexWeight(i, Integer.MAX_VALUE);
			int[] parents = new int[vertices + 1];
			weightArray[source].weight = 0;
			Heap<VertexWeight> heap = heapOperations.makeHeap(weightArray);
			while (!heap.isEmpty()) {
				VertexWeight vertexWeight = heapOperations.extractMin(heap);
				int vertex = vertexWeight.vertex;
				EdgeNode adjacencyList = edges[vertex];
				while (adjacencyList != null) {
					int y = adjacencyList.getY();
					VertexWeight adjacent = weightArray[y];
					if (adjacent.weight > adjacencyList.getWeight()) {
						adjacent.weight = adjacencyList.getWeight();
						parents[y] = vertex;
//						heapOperations.decreaseKey(heap, index, adjacent);
					}

					adjacencyList = adjacencyList.getNext();
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readWeightedGraph(g, false);
		Graphs.printGraph(g);
	}
}
