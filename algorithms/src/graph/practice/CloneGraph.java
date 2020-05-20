package graph.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a reference of a node in a connected undirected graph.
 * 
 * Return a deep copy (clone) of the graph.
 * 
 * Each node in the graph contains a val (int) and a list (List[Node]) of its
 * neighbors. For simplicity sake, each node's value is the same as the node's
 * index (1-indexed). For example, the first node with val = 1, the second node
 * with val = 2, and so on. The graph is represented in the test case using an
 * adjacency list.
 * 
 * Adjacency list is a collection of unordered lists used to represent a finite
 * graph. Each list describes the set of neighbors of a node in the graph.
 * 
 * The given node will always be the first node with val = 1. You must return
 * the copy of the given node as a reference to the cloned graph.
 * 
 * @author rajan-c
 *
 */
public class CloneGraph {
	public static Node cloneGraph(Node node) {
		Map<Integer, Node> map = new HashMap<>();
		if (node == null)
			return null;
		return deepClone(node, map);
	}

	private static Node deepClone(Node node, Map<Integer, Node> processed) {
		if (processed.containsKey(node.val))
			return processed.get(node.val);
		Node clone = new Node(node.val);
		processed.put(clone.val, clone);
		List<Node> adjacency = node.neighbors;
		for (Node neighour : adjacency)
			clone.neighbors.add(deepClone(neighour, processed));
		return clone;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);

		node2.neighbors.add(node1);
		node2.neighbors.add(node3);

		node3.neighbors.add(node4);
		node3.neighbors.add(node2);

		node4.neighbors.add(node1);
		node4.neighbors.add(node3);

		Node clone = cloneGraph(node1);
		System.out.println(clone);
	}

}
