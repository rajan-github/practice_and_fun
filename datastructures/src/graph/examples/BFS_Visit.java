package graph.examples;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Visit {
	public void bfsVisit(Graph graph) {
		if (graph != null) {
			Queue<Vertex> queue = new LinkedList<>();
			queue.add(graph.getVertices().get(0));
			graph.getVertices().get(0).setCOLOR(Color.GRAY);
			while (!queue.isEmpty()) {
				Vertex v = queue.remove();
				System.out.println(v);
				List<Vertex> adjacents = v.getAdjacentList();
				for (Vertex adjacent : adjacents) {
					if (adjacent.getCOLOR() == Color.WHITE) {
						adjacent.setCOLOR(Color.GRAY);
						adjacent.setParent(v);
						queue.add(adjacent);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex(new int[] { 0, 1, 2, 3 });

		graph.addEdge(graph.getVertices().get(0), graph.getVertices().get(1));
		graph.addEdge(graph.getVertices().get(0), graph.getVertices().get(2));
		graph.addEdge(graph.getVertices().get(1), graph.getVertices().get(2));
		graph.addEdge(graph.getVertices().get(1), graph.getVertices().get(3));
		graph.addEdge(graph.getVertices().get(2), graph.getVertices().get(3));
		new BFS_Visit().bfsVisit(graph);
	}
}
