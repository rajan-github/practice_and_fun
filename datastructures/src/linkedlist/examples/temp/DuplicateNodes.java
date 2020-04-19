package linkedlist.examples.temp;

/**
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Return the linked list sorted as well. Input: 1->2->3->3->4->4->5 Output:
 * 1->2->5
 * 
 * @author rajan-c
 *
 */
public class DuplicateNodes {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = null, previousNode = null;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				ListNode nextNode = getNextNode(head);
				if (previousNode != null)
					previousNode.next = nextNode;
				head = nextNode;
			} else if (newHead == null) {
				newHead = head;
				previousNode = head;
				head = head.next;
			} else {
				previousNode = head;
				head = head.next;
			}
		}

		if (newHead == null)
			newHead = head;
		return newHead;
	}

	private static ListNode getNextNode(ListNode node) {
		if (node == null || node.next == null || node.val != node.next.val)
			return (node == null) ? node : node.next;
		ListNode temp = node;
		while (temp != null && temp.next != null && temp.val == temp.next.val)
			temp = temp.next;
		return temp == null ? temp : temp.next;
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
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(3);
		display(head);
		display(deleteDuplicates(head));

//		System.out.println(getNextNode(head).val);
//		System.out.println(getNextNode(head.next).val);
//		System.out.println(getNextNode(head.next.next).val);
	}
}
