package linkedlist.examples.temp;

/**
 * Reverse a singly linked list.
 * 
 * @author rajan-c
 *
 */
public class ReverseList {
	public static ListNode reverseList(ListNode head) {
		return reverseList(head, null);
	}

	public static ListNode reverseList(ListNode head, ListNode previous) {
		if (head == null)
			return previous;
		ListNode next = head.next;
		head.next = previous;
		return reverseList(next, head);
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		head = reverseList(head);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}

	}
}
