package linkedlist.examples.temp;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class MergeSortedLists {
	public LinkNode mergeTwoLists(LinkNode l1, LinkNode l2) {
		LinkNode merged = new LinkNode(), head = merged;
		while (l1 != null || l2 != null) {
			if (l1 != null && ((l2 != null && l1.getData() <= l2.getData()) || l2 == null)) {
				merged.setNext(l1);
				l1 = l1.getNext();
			} else {
				merged.setNext(l2);
				l2 = l2.getNext();
			}
			merged = merged.getNext();
		}
		return head.getNext();
	}

	public static void main(String[] args) {
		MergeSortedLists merge = new MergeSortedLists();
		SinglyList list1 = new SinglyList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(4);
		list1.insertAtEnd(6);
		list1.insertAtEnd(9);

		SinglyList list2 = new SinglyList();
		list2.insertAtEnd(2);
		list2.insertAtEnd(5);
		list2.insertAtEnd(7);
		list2.insertAtEnd(8);

		list1.setHead(merge.mergeTwoLists(null, null));
		list1.display();
	}
}
