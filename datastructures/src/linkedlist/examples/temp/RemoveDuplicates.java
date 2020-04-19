package linkedlist.examples.temp;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * @author rajan-c
 *
 */
public class RemoveDuplicates {

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode iterator = head;
		while (iterator != null) {
			ListNode distinctNode = nextNode(iterator);
			iterator.next = distinctNode;
			iterator = distinctNode;
		}
		return head;
	}

	private static ListNode nextNode(ListNode node) {
		ListNode distinctNode = node;
		while (distinctNode != null && distinctNode.val == node.val)
			distinctNode = distinctNode.next;
		return distinctNode;
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
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(4);
//		head.next.next.next.next.next = new ListNode(5);
		display(head);
		display(deleteDuplicates(head));

	}
}
