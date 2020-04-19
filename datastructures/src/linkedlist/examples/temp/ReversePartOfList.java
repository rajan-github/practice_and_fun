package linkedlist.examples.temp;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author rajan-c
 *
 */
public class ReversePartOfList {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode previousToMthNode = null, nthNode = head, mthNode = head;
		n = n - m;
		while (m-- > 1) {
			previousToMthNode = mthNode;
			mthNode = mthNode.next;
		}
		nthNode = mthNode;
		while (n-- >= 1)
			nthNode = nthNode.next;
		ListNode remaining = nthNode.next;
		nthNode.next = null;
		if (previousToMthNode != null)
			previousToMthNode.next = reverseList(mthNode, null);
		else {
			previousToMthNode = reverseList(mthNode, null);
			head = previousToMthNode;
		}

		mthNode.next = remaining;
		return head;
	}

	private static ListNode reverseList(ListNode head, ListNode previous) {
		if (head == null) {
			return previous;
		}
		ListNode temp = head.next;
		head.next = previous;
		return reverseList(temp, head);
	}

	private static void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = reverseBetween(head, 1, 2);
		display(head);
	}

}
