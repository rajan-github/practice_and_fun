package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem47 {
	public static LinkNode findModularNode(LinkNode head, int k) {
		if (head != null && k > 0) {
			LinkNode temp = head, modularNode = null;
			int i = 1;
			while (temp != null) {
				if (i % k == 0)
					modularNode = temp;
				temp = temp.getNext();
				i++;
			}
			return modularNode;
		}
		return head;
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		list.insertAtEnd(9);
		list.insertAtEnd(10);
		list.insertAtEnd(11);
		list.insertAtEnd(12);
		list.insertAtEnd(13);
		list.insertAtEnd(14);
		list.insertAtEnd(15);
		list.insertAtEnd(16);
		list.insertAtEnd(17);
		list.insertAtEnd(18);
		list.insertAtEnd(19);

		LinkNode temp = findModularNode(list.getHead(), 3);
		if (temp != null) {
			System.out.println(temp.getData());
		}
	}
}
