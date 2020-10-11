package graph.exercise.chap23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import disjointset.tree.SetOperations;
import disjointset.tree.TreeNode;

public class MinimumSpanningTree {
	public static int mstByKrushkal(int vertices, int[][] edges) {
		if (vertices <= 0 || edges == null || edges.length == 0)
			return 0;
		Comparator<? super int[]> comparator = (int[] o1, int[] o2) -> {
			if (o1[2] > o2[2])
				return 1;
			else if (o1[2] == o2[2])
				return 0;
			return -1;
		};

		Arrays.sort(edges, comparator);
		SetOperations<Integer> setOperations = new SetOperations<>();
		Set<TreeNode<Integer>> set = new HashSet<>();
		for (int i = 1; i <= vertices; i++)
			set.add(setOperations.makeset(i));

		int weight = 0;
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			TreeNode<Integer> xSet = setOperations.findset(setOperations.getNode(x)),
					ySet = setOperations.findset(setOperations.getNode(y));
			if (xSet != ySet) {
				weight += edge[2];
				set.remove(setOperations.getNode(x));
				set.remove(setOperations.getNode(y));
				set.add(setOperations.union(xSet, ySet));
			}
		}
		return weight;
	}

	public static int mstByPrim(int vertices, int[][] edges) {
		if (vertices <= 0 || edges == null || edges.length == 0)
			return 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		Map<Integer, Vertex> vertexMap = new HashMap<>();
		// add source
		Vertex source = new Vertex(1, 0);
		queue.add(source);
		vertexMap.put(1, source);
		for (int i = 2; i <= vertices; i++) {
			Vertex node = new Vertex(i, Integer.MAX_VALUE);
			queue.add(node);
			vertexMap.put(i, node);
		}

		Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0];
			if (!adjacencyMap.containsKey(x))
				adjacencyMap.put(x, new ArrayList<>());

			adjacencyMap.get(x).add(edge);
		}

		while (!queue.isEmpty()) {
			Vertex node = queue.poll();
			List<int[]> adjacencyList = adjacencyMap.get(node.id);
			if (adjacencyList != null) {
				for (int[] edge : adjacencyList) {
					Vertex y = vertexMap.get(edge[1]);
					queue.remove(y);
					if (y.weight > edge[2]) {
						y.weight = edge[2];
						y.parent = vertexMap.get(edge[0]);
					}
					queue.add(y);
				}
			}
		}

		int weight = 0;
		for (Map.Entry<Integer, Vertex> entry : vertexMap.entrySet())
			weight += entry.getValue().weight;
		return weight;
	}

	public static int mstForAdjancencyMatrix(int[][] graph) {
		if (graph == null || graph.length == 0)
			return 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		Map<Integer, Vertex> vertexMap = new HashMap<>();
		Set<Integer> processed = new HashSet<>();

		int source = 0;
		Vertex sourceNode = new Vertex(source, 0);
		processed.add(source);
		queue.add(sourceNode);
		vertexMap.put(source, sourceNode);

		for (int i = 1; i < graph.length; i++) {
			Vertex node = new Vertex(i, Integer.MAX_VALUE);
			queue.add(node);
			vertexMap.put(i, node);
		}

		int weight = 0;
		while (!queue.isEmpty()) {
			Vertex node = queue.remove();
			weight += node.weight;
			processed.add(node.id);
			int[] adjacencyList = graph[node.id];
			for (int i = 0; i < adjacencyList.length; i++) {
				if (adjacencyList[i] < Integer.MAX_VALUE && i != node.id && !processed.contains(i)) {
					Vertex adjacent = vertexMap.get(i);
					queue.remove(adjacent);
					if (adjacent.weight > adjacencyList[i])
						adjacent.weight = adjacencyList[i];
					queue.add(adjacent);
				}
			}
		}
		return weight;
	}

	public static void main(String[] args) {
		int[][] edges = new int[][] { { 1, 2, 1 }, { 1, 3, 1 }, { 2, 4, 2 }, { 3, 5, 3 }, { 3, 4, 1 }, { 4, 6, 4 },
				{ 5, 6, 5 }, { 1, 5, 2 } };
		System.out.println(mstByKrushkal(6, edges));
//		System.out.println(mstByPrim(6, edges));

		int[][] graph = new int[][] { { 0, 1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ 1, 0, Integer.MAX_VALUE, 16, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ 4, Integer.MAX_VALUE, 0, 3, 14, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, 16, 3, 0, Integer.MAX_VALUE, 5 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, 14, Integer.MAX_VALUE, 0, 6 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 6, 0 } };

		System.out.println(mstForAdjancencyMatrix(graph));
	}
}

class Vertex implements Comparable<Vertex> {
	int id;
	int weight;
	Vertex parent;

	public Vertex(int _id, int _weight) {
		this.id = _id;
		this.weight = _weight;
	}

	@Override
	public int compareTo(Vertex arg0) {
		if (this.weight > arg0.weight)
			return 1;
		else if (this.weight < arg0.weight)
			return -1;
		return 0;
	}
}
