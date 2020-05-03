package linkedlist.examples.temp;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author rajan-c
 *
 */
public class MergeSortedList {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		return merge(l1, l2, null, null);
	}

	private static ListNode merge(ListNode l1, ListNode l2, ListNode mergedHead, ListNode mergedTail) {
		if (l1 == null || l2 == null) {
			ListNode tomerge = l1 != null ? l1 : l2;
			if (mergedHead == null)
				return tomerge;
			else {
				while (tomerge != null) {
					mergedTail.next = tomerge;
					mergedTail = tomerge;
					tomerge = tomerge.next;
				}
				return mergedHead;
			}
		}
		ListNode nextNode;
		if (l1.val < l2.val)
			nextNode = l1;
		else
			nextNode = l2;
		if (mergedHead == null) {
			mergedHead = nextNode;
			mergedTail = nextNode;
		} else {
			mergedTail.next = nextNode;
			mergedTail = nextNode;
			nextNode = nextNode.next;
		}
		return merge(l1.val < l2.val ? l1.next : l1, l1.val >= l2.val ? l2.next : l2, mergedHead, mergedTail);
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		ListNode merged = mergeTwoLists(list1, list2);
		System.out.println(merged);
	}
}
