package graph.examples;

import java.util.ArrayList;
import java.util.List;

import linkedlist.examples.SinglyList;

/**
 * Graph representation with the linked list.
 * 
 * @author rajan-c
 *
 */
public class GraphWithList {
	private List<Integer> vertices;
	private SinglyList[] edges;

	private int vertexCount = 0;

	public GraphWithList(int vertexCount) {
		this.vertexCount = vertexCount;
		vertices = new ArrayList<>();
		edges = new SinglyList[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			vertices.add(i);
			edges[i] = new SinglyList();
		}
	}

	public void addEdge(int source, int destination) {
		if (source >= 0 && source < vertexCount && destination >= 0 && destination < vertexCount) {
			edges[source].insertAtFront(destination);
			edges[destination].insertAtFront(source);
		}

	}

}
