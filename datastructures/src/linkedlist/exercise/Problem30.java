package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem30 {
	public static boolean isListEvenLength(LinkNode head) {
		LinkNode fast = head;
		while (fast != null && fast.getNext() != null)
			fast = fast.getNext().getNext();
		return fast == null ? true : false;
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);

		System.out.println("Is list even: " + isListEvenLength(null));
		System.out.println("Is list even: " + isListEvenLength(list.getHead()));
		list.insertAtEnd(8);
		System.out.println("Is list even: " + isListEvenLength(list.getHead()));
	}
}
