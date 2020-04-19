package linkedlist.examples.temp;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 * 
 * @author rajan-c
 *
 */
public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;

		ListNode smallerList = head.val < x ? head : null, smallerListTail = smallerList, oldHead = head;
		while (head != null && head.val < x) {
			smallerListTail = head;
			head = head.next;
		}

		oldHead = head;
		if (smallerListTail != null)
			smallerListTail.next = null;

		while (head != null && head.next != null) {
			if (head.next.val >= x)
				head = head.next;
			else {
				ListNode deletedNode = head.next;
				head.next = deletedNode.next;
				if (smallerList == null) {
					smallerList = deletedNode;
					smallerListTail = smallerList;
				} else {
					smallerListTail.next = deletedNode;
					smallerListTail = deletedNode;
				}
			}
		}
		if (smallerListTail != null)
			smallerListTail.next = oldHead;
		return smallerList != null ? smallerList : oldHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(3);
//		head.next.next.next.next = new ListNode(2);
//		head.next.next.next.next.next = new ListNode(2);

		head = partition(head, 0);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
	}
}
