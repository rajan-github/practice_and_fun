package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

/**
 * reverse the blocks of k node in a link list.
 * 
 * @author rajan-c
 *
 */
public class Exercise41 {

	public static LinkNode reverseKNodes(LinkNode head, int k) {
		LinkNode temp = head, temp2, temp3 = null, reversedHead, previous = null, newHead = null;
		while (temp != null) {
			temp2 = temp;
			for (int i = 0; i < k - 1 && temp2 != null; i++) {
				temp2 = temp2.getNext();
			}
			if (temp2 != null) {
				temp3 = temp2.getNext();
				temp2.setNext(null);
			} else {
				temp3 = null;
			}
			reversedHead = reverseList(temp, null);
			if (previous == null)
				newHead = reversedHead;
			else {
				previous.setNext(reversedHead);
			}
			previous = getTail(reversedHead);
			temp = temp3;
		}
		return newHead;
	}

	private static LinkNode getTail(LinkNode head) {
		if (head != null) {
			while (head.getNext() != null)
				head = head.getNext();
			return head;
		}
		return head;
	}

	private static LinkNode reverseList(LinkNode head, LinkNode previous) {
		if (head == null)
			return head;
		else if (head != null && head.getNext() == null) {
			head.setNext(previous);
			return head;
		}
		LinkNode temp = head.getNext();
		head.setNext(previous);
		return reverseList(temp, head);
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.setHead(reverseKNodes(list.getHead(), 2));
		list.display();
	}

}
