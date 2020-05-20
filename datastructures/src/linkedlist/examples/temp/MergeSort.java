package linkedlist.examples.temp;

/**
 * Implement mergesort algorithm on linked list with constant space.
 * 
 * @author rajan-c
 *
 */
public class MergeSort {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode middle = head, iterator = head.next;
		while (iterator != null && iterator.next != null) {
			iterator = iterator.next.next;
			middle = middle.next;
		}
		ListNode right = middle.next;
		middle.next = null;
		ListNode left = sortList(head);
		right = sortList(right);
		return mergeList(left, right);

	}

	private static ListNode mergeList(ListNode left, ListNode right) {
		ListNode head = null, tail = null;
		while (left != null && right != null) {
			if (left.val <= right.val) {
				if (tail == null) {
					head = left;
					tail = left;
				} else {
					tail.next = left;
					tail = tail.next;
				}
				left = left.next;
			} else {
				if (tail == null) {
					head = right;
					tail = right;
				} else {
					tail.next = right;
					tail = tail.next;
				}
				right = right.next;
			}
		}
		while (left != null) {
			if (tail == null) {
				tail = left;
				head = left;
			} else {
				tail.next = left;
				tail = tail.next;
			}
			left = left.next;
		}

		while (right != null) {
			if (tail == null) {
				tail = right;
				head = right;
			} else {
				tail.next = right;
				tail = tail.next;
			}
			right = right.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(6);
		list1.next.next = new ListNode(5);
		list1.next.next.next = new ListNode(-1);

//		ListNode list2 = new ListNode(2);
//		list2.next = new ListNode(4);
//		list2.next.next = new ListNode(6);

		ListNode head = sortList(list1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

}
