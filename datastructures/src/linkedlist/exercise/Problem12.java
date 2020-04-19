package linkedlist.exercise;

import linkedlist.examples.CircularList;
import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem12 {
	public static boolean isListCyclic(LinkNode head) {
		if (head == null)
			return false;
		else {
			LinkNode slow = head.getNext(), fast = head.getNext().getNext();

			while (fast != slow && fast != null) {
				slow = slow.getNext();
				fast = fast.getNext() != null ? fast.getNext().getNext() : fast.getNext();
			}
			if (fast == slow) {
				slow = head;
				while (slow != fast) {
					slow = slow.getNext();
					fast = fast.getNext();
				}
				System.out.println("Cycle starting node is: " + slow.getData());
				return true;
			} else {
				System.out.println("Cycle doesn't exist!");
				return false;
			}
		}
	}

	public static void main(String[] args) {
		CircularList clist = new CircularList();
		clist.insertAtEnd(1);
		clist.insertAtEnd(2);
		clist.insertAtEnd(3);
		clist.insertAtEnd(4);

		System.out.println("Is there cycle: " + isListCyclic(clist.getTail()));

		SinglyList slist = new SinglyList();

		slist.insertAtEnd(1);
		slist.insertAtEnd(2);
		slist.insertAtEnd(3);
		slist.insertAtEnd(4);
		System.out.println("Is there cycle: " + isListCyclic(slist.getHead()));
	}
}
