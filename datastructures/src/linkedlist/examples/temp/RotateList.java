package linkedlist.examples.temp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative. Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL
 * 
 * @author rajan-c
 *
 */
public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0 || head.next == null)
			return head;
		int size = 0;
		ListNode tail = head;
		Map<Integer, ListNode> map = new HashMap<>();
		while (tail.next != null) {
			map.put(size, tail);
			tail = tail.next;
			size++;
		}
		map.put(size, tail);
		size++;
		k = k % size;
		if (k > 0) {
			int unchangedLength = size - k;
			ListNode tempHead = map.get(unchangedLength - 1);
			ListNode remaining = tempHead.next;
			tempHead.next = null;
			tail.next = head;
			return remaining;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode newHead = rotateRight(head, 2);
//		ListNode newHead = reverse(head, null);
		while (newHead != null) {
			System.out.print(newHead.val + "->");
			newHead = newHead.next;
		}
		System.out.println("null");
	}
}
