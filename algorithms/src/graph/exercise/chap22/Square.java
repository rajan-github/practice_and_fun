package graph.exercise.chap22;

import java.util.HashSet;
import java.util.Set;

import auxiliaryMethods.CommonMethods;
import graph.EdgeNode;
import graph.Graph;
import graph.Graphs;

public class Square {

	/**
	 * The square of a directed graph G(V, E) is the graph G2(V, E2) such that (u,v)
	 * belongs to E2 if and only G contains a path with at most two edges between u
	 * and v. Describe efficient algorithms for computing G2 from G for both the
	 * adjacency- list and adjacency-matrix representations of G. Analyze the
	 * running times of your algorithms.
	 * 
	 * @param adjacencyMatrix
	 * @return
	 */
	public static int[][] squareOfAdjacencyList(int[][] adjacencyMatrix) {
		if (adjacencyMatrix == null)
			return null;
		int[][] square = new int[adjacencyMatrix.length][adjacencyMatrix.length];
		int length = adjacencyMatrix.length;
		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				int distance = 0;
				inner: for (int k = 0; k < length; k++) {
					distance = Math.max(distance, adjacencyMatrix[row][k] + adjacencyMatrix[k][col]);
					if (distance >= 2) {
						square[row][col] = 1;
						break inner;
					}
				}
				if (square[row][col] == 0 && adjacencyMatrix[row][col] > 0)
					square[row][col] = adjacencyMatrix[row][col];
			}
		}
		return square;
	}

	public static Graph square(Graph g) {
		if (g == null)
			return null;
		Graph square = new Graph();
		int vertices = g.getNvertices();
		square.setNvertices(vertices);
		EdgeNode[] edgeList = g.getEdges();
		Set<Integer> inserted = new HashSet<>();
		for (int v = 1; v <= vertices; v++) {
			EdgeNode adjacencyList = edgeList[v];
			inserted.clear();
			while (adjacencyList != null) {
				int y = adjacencyList.getY();
				if (!inserted.contains(y))
					Graphs.insertEdge(square, v, y, 1, g.isDirected());
				EdgeNode adjacentToAdjacent = edgeList[y];
				while (adjacentToAdjacent != null) {
					int distanceTwoVertex = adjacentToAdjacent.getY();
					if (!inserted.contains(distanceTwoVertex)) {
						inserted.add(distanceTwoVertex);
						Graphs.insertEdge(square, v, distanceTwoVertex, 1, g.isDirected());
					}
					adjacentToAdjacent = adjacentToAdjacent.getNext();
				}
				adjacencyList = adjacencyList.getNext();
			}
		}
		return square;
	}

	public static void main(String[] args) {
		int[][] adjacencyMatrix = new int[][] { { 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 } };

		int[][] sqaure = squareOfAdjacencyList(adjacencyMatrix);
		CommonMethods.display(sqaure);

		Graph g = new Graph();
		Graphs.readGraph(g, true);
		Graph square = square(g);
		Graphs.printGraph(square);
	}
}
