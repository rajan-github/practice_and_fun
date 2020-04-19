package graph.examples;

import java.util.LinkedList;

public class DFS_Visit {

	private int time;

	public void dfs_visit(Graph graph) {
		initialize(graph);
		for (Vertex v : graph.getVertices()) {
			if (v.getCOLOR() == Color.WHITE) {
				dfs(v);
			}
		}
	}

	private void dfs(Vertex v) {
		time = time + 1;
		v.setDiscoveryTime(time);
		v.setCOLOR(Color.GRAY);
		System.out.println(v);
		LinkedList<Vertex> adjacentList = v.getAdjacentList();
		adjacentList.forEach(vertex -> {
			if (vertex.getCOLOR() == Color.WHITE) {
				vertex.setParent(v);
				dfs(vertex);
			}
		});
		time = time + 1;
		v.setFinishedTime(time);
		v.setCOLOR(Color.BLACK);
	}

	private void initialize(Graph graph) {
		for (Vertex v : graph.getVertices()) {
			v.setCOLOR(Color.WHITE);
			v.setParent(null);
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
		new DFS_Visit().dfs_visit(graph);

	}

}
