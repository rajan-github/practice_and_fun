package disjointsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the set.
 * 
 * @author rajan-c
 *
 */
class Set {
	Node tail;
	Node head;
	int length;
}

/**
 * Represents the item in set.
 * 
 * @author rajan-c
 *
 */
class Node {
	int data;

	Node(int data) {
		this.data = data;
	}

	Node next;
	Set head;

	@Override
	public String toString() {
		return "" + data;
	}
}

public class DisjointSetWithLinkedList {
	private Map<Integer, Node> itemToNodeMap = new HashMap<>();

	public Set makeSet(int x) {
		Set set = new Set();
		Node node = new Node(x);
		node.head = set;
		set.head = node;
		set.tail = node;
		set.length += 1;
		itemToNodeMap.put(x, node);
		return set;
	}

	public Set union(int x, int y) {
		Node nodex = itemToNodeMap.get(x);
		Node nodey = itemToNodeMap.get(y);
		if (nodex == null || nodey == null)
			return null;

		Set setx = nodex.head;
		Set sety = nodey.head;
		if (setx.length > sety.length) {
			Node iterator = sety.head;
			setx.tail.next = iterator;
			while (iterator != null) {
				iterator.head = setx;
				if (iterator.next == null)
					setx.tail = iterator;
				iterator = iterator.next;
			}
			setx.length += sety.length;
			return setx;
		} else {
			Node iterator = setx.head;
			sety.tail.next = iterator;
			while (iterator != null) {
				iterator.head = sety;
				if (iterator.next == null)
					sety.tail = iterator;
				iterator = iterator.next;
			}
			sety.length += setx.length;
			return sety;
		}
	}

	public Set findSet(int x) {
		Node node = itemToNodeMap.get(x);
		if (node == null)
			return null;
		return node.head;
	}

	public static void main(String[] args) {
		DisjointSetWithLinkedList ds = new DisjointSetWithLinkedList();
		List<Set> set = new ArrayList<>();

		for (int i = 1; i <= 16; i++)
			set.add(ds.makeSet(i));

		List<Set> set1 = new ArrayList<>();

		for (int i = 1; i <= 16; i += 2)
			set1.add(ds.union(i, i + 1));

		System.out.println(set1.size());
		for (Set item : set1) {
			Node head = item.head;
			while (head != null) {
				System.out.print(head + ", ");
				head = head.next;
			}
		}

		List<Set> set2 = new ArrayList<>();

		for (int i = 1; i <= 16; i += 4)
			set2.add(ds.union(i, i + 2));

		System.out.println(set2.size());
		for (Set item : set2) {
			Node head = item.head;
			while (head != null) {
				System.out.print(head + ", ");
				head = head.next;
			}
		}

	}
}
