package practice.graph.tree.disjointSets;

public class Node {
	Node parent;
	int data;
	int rank;

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node parent) {
		this.data = data;
		this.parent = parent;
	}

}
