package graph;

import java.util.Scanner;

/**
 * This class has general graph operations like insert edge in graph, read graph
 * and print graphs.
 * 
 * @author rajan-c
 *
 */
public class Graphs {

	/*
	 * Insert an edge (x,y).
	 */
	public static void insertEdge(Graph g, int x, int y, boolean directed) {
		if (g != null) {
			EdgeNode p = new EdgeNode();
			p.setY(y);
			p.setNext(g.getEdges()[x]);
			g.getEdges()[x] = p;
			g.increaseDegree(x);
			if (directed)
				g.setNedges(g.getNedges() + 1);
			else
				insertEdge(g, y, x, true);
		}
	}

	/**
	 * Graph format consists of an initial line featuring the number of vertices and
	 * edges in the graph, followed by a listing of the edges at one vertex pair per
	 * line.
	 * 
	 * @param g
	 * @param directed
	 */
	public static void readGraph(Graph g, boolean directed) {
		int edges = 0, vertices = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter graph: ");
			vertices = scanner.nextInt();
			edges = scanner.nextInt();
			g.setDirected(directed);
			if (vertices > 0)
				g.setNvertices(vertices);

			for (int i = 1; i <= edges; i++) {
				insertEdge(g, scanner.nextInt(), scanner.nextInt(), directed);
			}
		}
	}

	public static void printGraph(Graph g) {
		if (g != null) {
			int vertices = g.getNvertices();
			for (int v = 1; v <= vertices; v++) {
				EdgeNode adjacentList = g.getEdges()[v];
				System.out.print(v + ": ");
				while (adjacentList != null) {
					System.out.print(adjacentList.getY() + "->");
					adjacentList = adjacentList.getNext();
				}
				System.out.println();
			}
		}
	}

	public static Graph transpose(Graph g) {
		Graph transpose = new Graph();
		if (g != null) {
			int vertices = g.getNvertices();
			boolean isDirectred = g.isDirected();
			transpose.setNvertices(vertices);
			transpose.setDirected(isDirectred);
			EdgeNode[] adjacentArray = g.getEdges();
			for (int i = 1; i <= vertices; i++) {
				EdgeNode adjacencyList = adjacentArray[i];
				while (adjacencyList != null) {
					insertEdge(transpose, adjacencyList.getY(), i, isDirectred);
					adjacencyList = adjacencyList.getNext();
				}
			}
		}
		return transpose;
	}

	/**
	 * The square of a directed graph G(V,E) is the graph G2(V,E2) such that E2 is
	 * an edge if and only G contains a path with at most two edges between u and v.
	 * 
	 * @param g
	 * @return
	 */
	public static Graph square(Graph g) {
		if (g != null) {
			Graph square = new Graph();
			boolean isDirected = g.isDirected();
			square.setDirected(isDirected);
			EdgeNode[] adjacencyArray = g.getEdges();
			int vertices = g.getNvertices();
			square.setNvertices(vertices);
			for (int v = 1; v <= vertices; v++) {
				EdgeNode adjacencyList = adjacencyArray[v];
				while (adjacencyList != null) {
					insertEdge(square, v, adjacencyList.getY(), true);
					EdgeNode adjadjList = adjacencyArray[adjacencyList.getY()];
					while (adjadjList != null) {
						if (v != adjadjList.getY())
							insertEdge(square, v, adjadjList.getY(), true);
						adjadjList = adjadjList.getNext();
					}
					adjacencyList = adjacencyList.getNext();
				}
			}
			return square;
		}
		return g;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		readGraph(graph, false);
		printGraph(graph);
		Graph square = square(graph);
		System.out.println("Printing square graph.");
		printGraph(square);
	}
}
