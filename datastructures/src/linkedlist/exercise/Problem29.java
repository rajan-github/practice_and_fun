package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem29 {
	public static void displayInReverse(LinkNode head) {
		if (head == null)
			return;
		displayInReverse(head.getNext());
		System.out.println(head.getData());
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);

		displayInReverse(list.getHead());
	}
}
