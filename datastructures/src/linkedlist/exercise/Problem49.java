package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

/**
 * Find the n/kth node, where n is the length of the list and not known in
 * advance. K is a given number.
 * 
 * @author rajan-c
 *
 */
public class Problem49 {
	public static LinkNode getFractionalNode(LinkNode head, int k) {
		if (head == null || k <= 0)
			return null;
		int i = 0;
		LinkNode fractionalNode = null, iterator = head;
		while (iterator != null && iterator.getNext() != null) {
			if (i % k == 0) {
				fractionalNode = fractionalNode == null ? head : fractionalNode.getNext();
			}
			iterator = iterator.getNext();
			i++;
		}
		return fractionalNode;
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		System.out.println(getFractionalNode(list.getHead(), 2).getData());
	}
}
