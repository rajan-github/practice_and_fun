package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import disjointset.linkedList.Set;
import disjointset.linkedList.SetOperations;
import heap.Heap;
import heap.MinHeapOperations;

public class MinimumSpanningTree {

	/**
	 * This is krushkal's algorithm implementation for minimum spanning tree. It
	 * returns an array of those edges which are part of the minimum spanning tree.
	 * 
	 * @param g
	 * @return
	 */
	public static EdgeNode[] minSpanningTreeByKruskal(Graph g) {
		if (g != null) {
			int vertices = g.getNvertices();
			EdgeNode[] spanningTree = new EdgeNode[vertices - 1];
			EdgeNode[] edgeArray = new EdgeNode[g.isDirected() ? g.getNedges() : g.getNedges() * 2];
			EdgeNode[] edges = g.getEdges();

			SetOperations<Integer> setOperations = new SetOperations<>();
			Map<Integer, Set<Integer>> vertexToSetMap = new HashMap<>();
			// make set for each vertex and make edge array.
			for (int i = 1, edgeArrayIndex = 0; i <= vertices; i++) {
				EdgeNode adjacentList = edges[i];
				vertexToSetMap.put(i, setOperations.makeSet(i));
				while (adjacentList != null) {
					edgeArray[edgeArrayIndex++] = adjacentList;
					adjacentList = adjacentList.getNext();
				}
			}
			// sort the array
			Arrays.sort(edgeArray);
			int index = 0;
			// Process each edge and union the set if they are not in the same tree.
			for (EdgeNode edge : edgeArray) {
				if (setOperations.findSet(edge.getX()) != setOperations.findSet(edge.getY())) {
					Set<Integer> setX = vertexToSetMap.remove(setOperations.findSet(edge.getX()).getData());
					Set<Integer> setY = vertexToSetMap.remove(setOperations.findSet(edge.getY()).getData());

					Set<Integer> union = setOperations.union(setX, setY);
					vertexToSetMap.put(union.getHead().getData(), union);
					spanningTree[index++] = edge;
				}

			}
			return spanningTree;
		}
		return null;
	}

	/**
	 * This is prim algorithm implementation with min heap. It returns parent array,
	 * where a[i] is parent of vertex i.
	 * 
	 * @param g
	 * @return
	 */
	public static int[] minSpanningTreeByPrim(Graph g) {
		if (g != null) {
			MinHeapOperations<VertexWeight> heapOperations = new MinHeapOperations<>();
			EdgeNode[] edges = g.getEdges();
			int source = 1, vertices = g.getNvertices();
			VertexWeight[] weightArray = new VertexWeight[vertices];
			for (int i = 1; i <= vertices; i++)
				weightArray[i - 1] = new VertexWeight(i, Integer.MAX_VALUE);
			int[] parents = new int[vertices + 1];
			weightArray[source - 1].weight = 0;
			Heap<VertexWeight> heap = heapOperations.makeHeap(weightArray);
			while (!heap.isEmpty()) {
				VertexWeight vertexWeight = heapOperations.extractMin(heap);
				int vertex = vertexWeight.vertex;
				EdgeNode adjacencyList = edges[vertex];
				while (adjacencyList != null) {
					int y = adjacencyList.getY();
					VertexWeight adjacent = weightArray[y - 1];
					int index = heap.getIndex(adjacent);
					if (adjacent.weight > adjacencyList.getWeight()) {
						adjacent.weight = adjacencyList.getWeight();
						parents[y] = vertex;
						heapOperations.decreaseKey(heap, index, adjacent);
					}
					adjacencyList = adjacencyList.getNext();
				}
			}
			return parents;
		}
		return null;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readWeightedGraph(g, true);
//		Graphs.printGraph(g);
//		int parents[] = minSpanningTreeByPrim(g);
//		CommonMethods.display(parents);

		EdgeNode[] spanningTree = minSpanningTreeByKruskal(g);
		if (spanningTree != null) {
			for (EdgeNode edge : spanningTree)
				System.out.println(edge.getX() + "->" + edge.getY());
		} else
			System.out.println("Spanning tree is null");
	}
}
