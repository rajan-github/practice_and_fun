package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem40 {
	public static LinkNode exchangeAdjacent(LinkNode head) {
		LinkNode newHead = null;
		if (head != null) {
			LinkNode temp = head.getNext(), temp2 = temp.getNext(), previous = null;
			newHead = temp;
			while (temp2 != null) {
				temp.setNext(head);
				head.setNext(temp2);
				if (previous != null) {
					previous.setNext(temp);
				}
				previous = head;
				head = temp2;
				temp = head.getNext();
				temp2 = temp.getNext();
			}

		}
		return newHead;
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);

		list.setHead(exchangeAdjacent(list.getHead()));
		list.display();

	}
}
