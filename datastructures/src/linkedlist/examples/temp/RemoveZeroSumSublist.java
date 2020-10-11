package linkedlist.examples.temp;

/**
 * Remove all the sequences from the linked list which add up to zero.
 * 
 * @author rajan-c
 *
 */
public class RemoveZeroSumSublist {
	public static ListNode removeZeroSumSublists(ListNode head) {
		if (head == null)
			return head;
		ListNode iterator = head, previous = null;
		ListNode[] zeroSubListTail = new ListNode[1];
		boolean isSumZero = false;
		while (iterator != null) {
			isSumZero = listSumToZero(iterator, zeroSubListTail);
			if (isSumZero) {
				if (previous == null) {
					if (zeroSubListTail[0] != null)
						iterator = zeroSubListTail[0].next;
					else
						iterator = zeroSubListTail[0];
					head = iterator;
				} else {
					if (zeroSubListTail[0] != null)
						previous.next = zeroSubListTail[0].next;
					else
						previous.next = zeroSubListTail[0];
					iterator = previous.next;
				}
			} else {
				previous = iterator;
				iterator = iterator.next;
			}
		}
		return head;
	}

	private static boolean listSumToZero(ListNode head, ListNode[] subListTail) {
		if (head == null)
			return false;
		int sum = head.val;
		while (sum != 0 && head != null) {
			head = head.next;
			if (head != null)
				sum += head.val;
			if (sum == 0)
				break;
		}
		if (sum == 0)
			subListTail[0] = head;
		return sum == 0;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(-3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);
		System.out.println(removeZeroSumSublists(head));
	}
}
