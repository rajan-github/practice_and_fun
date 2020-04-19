package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

/**
 * Merge two sorted linked lists into a third list.
 * 
 * @author rajan-c
 *
 */
public class Problem32 {
	public static LinkNode merge(LinkNode list1, LinkNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		else {
			SinglyList mergedList = new SinglyList();
			LinkNode head1 = list1, head2 = list2;
			while (head1 != null && head2 != null) {
				if (head1.getData() < head2.getData()) {
					mergedList.insertAtEnd(head1.getData());
					head1 = head1.getNext();
				} else {
					mergedList.insertAtEnd(head2.getData());
					head2 = head2.getNext();
				}
			}
			while (head1 != null) {
				mergedList.insertAtEnd(head1.getData());
				head1 = head1.getNext();
			}

			while (head2 != null) {
				mergedList.insertAtEnd(head2.getData());
				head2 = head2.getNext();
			}
			return mergedList.getHead();
		}
	}
	
	

	public static void main(String[] args) {
		SinglyList list1 = new SinglyList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(4);
		list1.insertAtEnd(7);
		list1.insertAtEnd(9);
		list1.insertAtEnd(10);
		list1.insertAtEnd(11);

		SinglyList list2 = new SinglyList();
		list2.insertAtEnd(2);
		list2.insertAtEnd(4);
		list2.insertAtEnd(6);
		list2.insertAtEnd(8);
		list2.insertAtEnd(12);
		list1.setHead(merge(null, null));
		list1.display();
	}

}
