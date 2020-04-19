package linkedlist.examples.temp;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class SublistSearch {
	public static boolean isSublistFound(LinkNode sublist, LinkNode list) {
		boolean isFound = false;
		if (sublist != null && list != null) {
			LinkNode sublistHead = sublist;
			while (list != null) {
				if (sublistHead == null) {
					isFound = true;
					break;
				} else if (list.getData() == sublistHead.getData()) {
					list = list.getNext();
					sublistHead = sublistHead.getNext();
				} else {
					sublistHead = sublist;
					if (sublistHead.getData() == list.getData())
						sublistHead = sublistHead.getNext();
					list = list.getNext();
				}
			}
		}
		return isFound;
	}

	public static void main(String[] args) {
		SinglyList slist = new SinglyList();
		slist.insertAtEnd(1);
		slist.insertAtEnd(2);
		slist.insertAtEnd(2);
		slist.insertAtEnd(1);
		slist.insertAtEnd(2);
		slist.insertAtEnd(3);
		slist.insertAtEnd(5);

		SinglyList sublist = new SinglyList();
		sublist.insertAtEnd(1);
		sublist.insertAtEnd(2);
		sublist.insertAtEnd(3);
		sublist.insertAtEnd(4);
		System.out.println("Is sublist found: " + isSublistFound(sublist.getHead(), slist.getHead()));
	}
}
