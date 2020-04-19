package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

public class Problem18 {
	public static LinkNode findIntersection(LinkNode head1, int m, LinkNode head2, int n) {
		LinkNode intersect = null;

		if (head1 != null && head2 != null) {
			LinkNode temp1 = head1, temp2 = head2;
			while (Math.min(m, n) > 0 && temp1 != null && temp2 != null) {
				m--;
				n--;
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			}

			if (m > 0 && temp1 != null) {
				while (m > 0 && temp1 != null) {
					m--;
					temp1 = temp1.getNext();
				}
			} else if (n > 0 && temp2 != null) {
				while (n > 0 && temp2 != null) {
					temp2 = temp2.getNext();
					n--;
				}
			}
			if (temp1 == temp2) {
				return temp1;
			} else {
				System.out.println("No intersect point found!");
				return null;
			}
		}
		return intersect;
	}

	public static void main(String[] args) {
		SinglyList list1 = new SinglyList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(3);
		list1.insertAtEnd(4);
		list1.insertAtEnd(5);
		list1.insertAtEnd(6);
		list1.insertAtEnd(7);
		LinkNode head1 = list1.getHead(), tail1;
		tail1 = head1.getNext().getNext().getNext().getNext();

		SinglyList list2 = new SinglyList();
		list2.insertAtEnd(10);
		list2.insertAtEnd(11);
//		list2.insertAtEnd(12);
		LinkNode head2 = list2.getHead(), tail2;
 
		tail2 = head2.getNext();
		tail2.setNext(tail1);
		list2.display();
		
		System.out.println("Intersection is: "+findIntersection(head1, 4, head2, 2).getData());
	}
}
