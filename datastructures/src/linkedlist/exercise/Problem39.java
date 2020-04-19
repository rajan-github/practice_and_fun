package linkedlist.exercise;

import linkedlist.examples.LinkNode;
import linkedlist.examples.SinglyList;

/**
 * Is list palindrome.
 * 
 * @author rajan-c
 *
 */
public class Problem39 {

	public static boolean isPalindrome(LinkNode head) {
		boolean palidrome = true;
		LinkNode faster = head, slower = head;
		while (faster.getNext() != null && faster.getNext().getNext() != null) {
			faster = faster.getNext().getNext();
			slower = slower.getNext();
		}
		LinkNode list2, list1, tempList2 = slower.getNext();
		if (faster != null && faster.getNext() == null) {
			// odd
			list2 = reverse(slower.getNext(), null);
			list1 = head;
			slower.setNext(null);
		} else {
			// even
			list2 = reverse(slower.getNext(), null);
			list1 = head;
			slower.setNext(null);
		}
		while (list2 != null) {
			if (list1.getData() != list2.getData()) {
				palidrome = false;
				break;
			}
			list1 = list1.getNext();
			list2 = list2.getNext();
		}
		slower.setNext(reverse(tempList2, null));
		return palidrome;
	}

	public static LinkNode reverse(LinkNode head, LinkNode previous) {
		if (head == null) {
			return head;
		} else if (head != null && head.getNext() == null) {
			head.setNext(previous);
			return head;
		}
		LinkNode temp = head.getNext();
		head.setNext(previous);
		return reverse(temp, head);
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(4);
		list.insertAtEnd(2);
		list.insertAtEnd(1);
//		list.display();
		System.out.println(isPalindrome(list.getHead()));
		list.display();
	}

}
