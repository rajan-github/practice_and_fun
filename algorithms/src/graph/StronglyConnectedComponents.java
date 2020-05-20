package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import heap.Heap;
import heap.MaxHeapOperations;

/**
 * This implementation of the strongly connected component algorithm computes
 * the strongly connected components of the given graph. It returns List of
 * connected components.
 * 
 * @author rajan-c
 *
 */
public class StronglyConnectedComponents {
	public List<List<Integer>> stronglyConnectedComponents(Graph g) {
		if (g != null) {
			int vertices = g.getNvertices();
			int[] finishTimes = new int[vertices + 1];
			int[] discoveryTimes = new int[vertices + 1];
			int[] parents = new int[vertices + 1];
			new DFS().dfs(g, discoveryTimes, finishTimes, parents);
			g = Graphs.transpose(g);
			Integer[] finishTimesInteger = new Integer[finishTimes.length];
			for (int i = 0; i < finishTimes.length; i++)
				finishTimesInteger[i] = finishTimes[i];
			return dfs(g, finishTimesInteger);
		}
		return new ArrayList<>();
	}

	private List<List<Integer>> dfs(Graph g, Integer[] finishTimes) {
		List<List<Integer>> connectedComponents = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		int vertices = g.getNvertices();
		Map<Integer, Integer> finishTimeMap = new HashMap<>();
		for (int i = 1; i <= vertices; i++)
			finishTimeMap.put(finishTimes[i], i);
		MaxHeapOperations<Integer> heapOperations = new MaxHeapOperations<>();
		Heap<Integer> heap = new Heap<>(finishTimes.length);
		heapOperations.makeHeap(heap, finishTimes);
		while (visited.size() < vertices) {
			int vertex = finishTimeMap.get(heapOperations.extractMax(heap));
			if (!visited.contains(vertex)) {
				List<Integer> tree = new ArrayList<>();
				visited.add(vertex);
				tree.add(vertex);
				dfsVisit(g, vertex, visited, tree);
				connectedComponents.add(tree);
			}
		}
		return connectedComponents;
	}

	private void dfsVisit(Graph g, int source, Set<Integer> visited, List<Integer> tree) {
		EdgeNode[] edgeList = g.getEdges();
		EdgeNode adjacencyList = edgeList[source];
		while (adjacencyList != null) {
			int y = adjacencyList.getY();
			if (!visited.contains(y)) {
				visited.add(y);
				tree.add(y);
				dfsVisit(g, y, visited, tree);
			}
			adjacencyList = adjacencyList.getNext();
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readGraph(g, true);
		System.out.println(new StronglyConnectedComponents().stronglyConnectedComponents(g));
	}
}
