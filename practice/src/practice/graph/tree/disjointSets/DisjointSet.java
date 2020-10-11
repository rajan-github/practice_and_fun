package practice.graph.tree.disjointSets;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
	Map<Integer, Node> valueToNodeMap = new HashMap<>();

	public Node makeSet(int x) {
		if (valueToNodeMap.containsKey(x))
			return valueToNodeMap.get(x);
		Node newNode = new Node(x);
		newNode.parent = newNode;
		valueToNodeMap.put(x, newNode);
		return newNode;
	}

	public Node findSet(int x) {
		Node node = valueToNodeMap.getOrDefault(x, null);
		if (node == null)
			return node;
		if (node.parent == node)
			return node;
		node.parent = findSet(node.parent.data);
		return node.parent;
	}

	public Node union(int x, int y) {
		if (!valueToNodeMap.containsKey(x) || !valueToNodeMap.containsKey(y))
			return null;
		return link(findSet(x), findSet(y));
	}

	private Node link(Node root1, Node root2) {
		if (root1.rank > root2.rank) {
			root1.parent = root2;
			return root1;
		} else {
			root1.parent = root2;
			if (root1.rank == root2.rank)
				root2.rank += 1;
			return root2;
		}
	}

}
