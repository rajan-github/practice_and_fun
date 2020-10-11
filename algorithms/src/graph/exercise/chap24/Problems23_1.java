package graph.exercise.chap24;

import java.util.Arrays;

import graph.EdgeNode;
import graph.Graph;
import graph.Graphs;

public class Problems23_1 {
	public static boolean problem1(Graph g, int[] parents, int source) {
		if (g == null)
			return true;
		int vertices = g.getNvertices();
		int weights[] = new int[vertices + 1];
		for (int i = 1; i < weights.length; i++)
			weights[i] = Integer.MAX_VALUE;
		weights[source] = 0;
		EdgeNode[] edgeLists = g.getEdges();
		for (int i = 1; i < vertices; i++) {
			for (int v = 1; v <= vertices; v++) {
				EdgeNode adjacentList = edgeLists[v];
				while (adjacentList != null) {
					int x = adjacentList.getX(), y = adjacentList.getY();
					if (weights[y] > weights[x] + adjacentList.getWeight()) {
						weights[y] = weights[x] + adjacentList.getWeight();
						parents[y] = x;
					}
					adjacentList = adjacentList.getNext();
				}
			}
		}

		for (int i = 1; i < vertices; i++) {
			EdgeNode adjacentList = edgeLists[i];
			while (adjacentList != null) {
				int x = adjacentList.getX(), y = adjacentList.getY();
				if (weights[y] > weights[x] + adjacentList.getWeight())
					return false;
				adjacentList = adjacentList.getNext();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.setDirected(true);
		Graphs.readWeightedGraph(g, true);
		int[] parents = new int[6];
		int source = 5;
		if (problem1(g, parents, source))
			System.out.println(Arrays.toString(parents));
		else
			System.out.println("Graph has negative weight cycle.");

	}
}
