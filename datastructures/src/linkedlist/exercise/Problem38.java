package linkedlist.exercise;

import linkedlist.examples.LinkNode;

public class Problem38 {
	public static void splitList(LinkNode tail, LinkNode head1, LinkNode head2) {
		if (tail != null) {
			if (tail == tail.getNext()) {
				tail.setNext(null);
				head1 = tail;
			} else {
				LinkNode fast = tail.getNext().getNext(), slow = tail.getNext();
				while (fast != tail && fast != tail.getNext()) {
					fast = fast.getNext().getNext();
					slow = slow.getNext();
				}

				head2 = slow.getNext();
				slow.setNext(null);
				head1 = tail.getNext();
				tail.setNext(null);
			}
		}
	}

	public static void main(String[] args) {

	}
}
