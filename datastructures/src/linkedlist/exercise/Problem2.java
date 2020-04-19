package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem2 {

	public LinkNode NthNodeFromEnd(LinkNode head, int n) {
		LinkNode nthNode = null, temp = head;
		int length = 0;
		while (temp != null) {
			temp = temp.getNext();
			length++;
		}
		if (n < length) {
			length = length - n;
			while (length > 0) {
				head = head.getNext();
				length--;
			}
			nthNode = head;
		}
		return nthNode;
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.display();
		LinkNode nthnode = new Problem2().NthNodeFromEnd(list.getHead(), 3);
		System.out.println("3rd node is: "+nthnode.getData());
	}
}
