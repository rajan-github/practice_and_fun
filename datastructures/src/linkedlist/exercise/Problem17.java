package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem17 {
	public static LinkNode reverseList(LinkNode head) {
		if (head != null) {
			LinkNode pre = null, suc = head, temp;
			while (suc != null) {
				temp = suc.getNext();
				suc.setNext(pre);
				pre = suc;
				suc = temp;
			}
			head = pre;
		}
		return head;
	}

	public static LinkNode reverseRecursive(LinkNode head, LinkNode pre) {
		if (head == null)
			return pre;
		LinkNode temp = head.getNext();
		head.setNext(pre);
		return reverseRecursive(temp, head);
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.display();
		list.setHead(reverseList(list.getHead()));
		list.display();
		System.out.println();
		list.setHead(reverseRecursive(list.getHead(), null));
		list.display();
	}
}
