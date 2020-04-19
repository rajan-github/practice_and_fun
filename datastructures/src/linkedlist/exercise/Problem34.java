package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

/**
 * Reverse the link list in pairs.
 * 
 * @author rajan-c
 *
 */
public class Problem34 {
	/**
	 * Recursive version
	 * 
	 * @param head
	 * @return
	 */
	public static LinkNode reversePairRecursive(LinkNode head) {
		if (head == null || head.getNext() == null)
			return head;
		else {
			LinkNode temp = head.getNext(), temp2 = temp.getNext();
			temp.setNext(head);
			head.setNext(reversePairRecursive(temp2));
			return temp;
		}
	}

	public static LinkNode reversePairIterative(LinkNode head) {
		if (head != null && head.getNext() != null) {
			LinkNode newHead = head.getNext(), temp = null, temp2 = null, predecHead = null;
			while (head != null && head.getNext() != null) {
				if (predecHead != null)
					predecHead.setNext(head.getNext());
				temp = head.getNext();
				temp2 = temp.getNext();
				temp.setNext(head);
				head.setNext(temp2);
				predecHead = head;
				head = temp2;
			}
			return newHead;
		}
		return head;

	}

	public static void main(String[] args) {
		SinglyList list1 = new SinglyList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(3);
		list1.insertAtEnd(4);
		list1.insertAtEnd(5);
		list1.setHead(reversePairIterative(list1.getHead()));
		list1.display();

	}
}
