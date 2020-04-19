package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem33 {
	public static LinkNode merge(LinkNode list1, LinkNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null) {
			return list1;
		} else {
			LinkNode newList = new LinkNode();
			if (list1.getData() < list2.getData()) {
				newList.setData(list1.getData());
				newList.setNext(merge(list1.getNext(), list2));
			} else {
				newList.setData(list2.getData());
				newList.setNext(merge(list1, list2.getNext()));
			}
			return newList;
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
		list1.setHead(merge(list1.getHead(), list2.getHead()));
		list1.display();
	}
}
