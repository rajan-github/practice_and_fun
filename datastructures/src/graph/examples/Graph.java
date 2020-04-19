package graph.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private List<Vertex> vertices = new ArrayList<>();

	public Graph() {
		super();
	}

	public void addVertex(int[] nums) {
		for (int i : nums) {

			vertices.add(new Vertex(Color.WHITE, null, i, new LinkedList<Vertex>()));
		}
	}

	public void addEdge(Vertex source, Vertex destination) {
		if (source != null && destination != null) {
			vertices.get(source.getNumber()).getAdjacentList().addFirst(destination);
			vertices.get(destination.getNumber()).getAdjacentList().addFirst(source);
		}
	}

	public int getVertexCount() {
		return vertices.size();
	}

	public List<Vertex> getVertices() {
		return this.vertices;
	}

}
