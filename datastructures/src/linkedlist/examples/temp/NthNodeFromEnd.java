package linkedlist.examples.temp;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

/**
 * Remove nth node from end
 * 
 * @author rajan-c
 *
 */
public class NthNodeFromEnd {

	public LinkNode removeNthFromEnd(LinkNode head, int n) {
		LinkNode oldHead = head;
		if (head != null) {
			LinkNode temp = head;
			while (n > 0) {
				head = head.getNext();
				n--;
			}
			while (head != null && head.getNext() != null) {
				head = head.getNext();
				temp = temp.getNext();
			}
			if (head == null) {
				oldHead = oldHead.getNext();
			} else if (temp.getNext() != null) {
				temp.setNext(temp.getNext().getNext());
			}
		}
		return oldHead;
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		NthNodeFromEnd temp = new NthNodeFromEnd();
		list.setHead(temp.removeNthFromEnd(list.getHead(), 1));
		list.display();

	}

}
