package linkedlist.examples.temp;

public class ReverseNodesInKGroup {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k > 0 && head != null) {
			ListNode kthNode = getKthNode(head, k), previousNode = null, newHead = (kthNode != null) ? kthNode : head;
			while (head != null && kthNode != null) {
				ListNode remaining = kthNode.next;
				kthNode.next = null;
				ListNode reversed = reverse(head, null);
				if (previousNode != null) {
					previousNode.next = reversed;
				}
				getTail(reversed).next = remaining;
				previousNode = head;
				head = remaining;
				kthNode = getKthNode(head, k);
			}
			return newHead;
		}
		return head;
	}

	private static ListNode getTail(ListNode head) {
		while (head != null && head.next != null)
			head = head.next;
		return head;
	}

	/**
	 * returns null if list is shorter than k.
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode getKthNode(ListNode head, int k) {
		while (head != null && k > 1) {
			k--;
			head = head.next;
		}
		return head;
	}

	private static ListNode reverse(ListNode head, ListNode previous) {
		if (head == null)
			return previous;
		if (head.next == null) {
			head.next = previous;
			return head;
		}
		ListNode temp = head.next;
		head.next = previous;
		return reverse(temp, head);
	}

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		list.next.next.next.next.next = new ListNode(6);
		list = reverseKGroup(list, 7);
		while (list != null) {
			System.out.print(list.val + ",");
			list = list.next;
		}
//		System.out.println("This was all in the list!");
	}
}
