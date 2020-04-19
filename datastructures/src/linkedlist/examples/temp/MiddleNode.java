package linkedlist.examples.temp;

/**
 * 
 * @author rajan-c
 *
 */
public class MiddleNode {
	public static ListNode middleNode(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode middle = head;
		while (head != null && head.next != null && head.next.next != null) {
			middle = middle.next;
			head = head.next.next;
		}

		if (head != null && head.next != null)
			middle = middle.next;
		return middle;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);

		System.out.println(middleNode(head).val);

//		ListNode head = new ListNode(1);
//		ListNode head = new ListNode(1);

	}
}
