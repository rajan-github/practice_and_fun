package practice.graph.disjointSets;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetWithList {

	private Map<Integer, Node> valueMap = new HashMap<>();

	public RootNode makeSet(int data) {
		RootNode root = new RootNode();
		Node node = new Node(data);
		valueMap.put(node.data, node);
		root.count = 1;
		root.head = node;
		root.tail = node;
		node.head = root;
		return root;
	}

	public int findSet(int x) {
		Node node = valueMap.get(x);
		return node.head.head.data;
	}

	public RootNode union(int x, int y) {
		if (findSet(x) == findSet(y))
			return valueMap.get(x).head;
		RootNode root1 = valueMap.get(x).head;
		RootNode root2 = valueMap.get(y).head;
		return link(root1, root2);
	}

	private RootNode link(RootNode root1, RootNode root2) {
		if (root1.count > root2.count) {
			root1.tail.next = root2.head;
			root1.count += root2.count;
			Node iterator = root2.head;
			while (iterator != null) {
				iterator.head = root1;
				iterator = iterator.next;
			}
			return root1;
		} else {
			root2.tail.next = root1.head;
			root2.count += root1.count;
			Node iterator = root1.head;
			while (iterator != null) {
				iterator.head = root2;
				iterator = iterator.next;
			}
			return root2;
		}
	}

	public static void main(String[] args) {
//		DisjointSetWithList disjoint = new DisjointSetWithList();
//		RootNode r1 = disjoint.makeSet(1);
//		RootNode r2 = disjoint.makeSet(2);
//		RootNode r3 = disjoint.makeSet(3);
//
//		RootNode r4 = disjoint.makeSet(4);
//		RootNode r5 = disjoint.makeSet(5);
//		RootNode r6 = disjoint.makeSet(6);
//		RootNode r7 = disjoint.makeSet(7);
//		RootNode r8 = disjoint.makeSet(8);
//		RootNode r9 = disjoint.makeSet(9);
//		r1 = disjoint.union(1, 2);
////		System.out.println(disjoint.findSet(1) + ", " + disjoint.findSet(2));
//		r3 = disjoint.union(3, 4);
//		r5 = disjoint.union(5, 6);
//		r7 = disjoint.union(7, 8);
//		r8 = disjoint.union(7, 9);
//
//		r1 = disjoint.union(1, 7);
//		r1 = disjoint.union(1, 4);
//		System.out.println(disjoint.findSet(1) + ", " + disjoint.findSet(4));

	}

}
