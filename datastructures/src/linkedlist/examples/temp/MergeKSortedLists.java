package linkedlist.examples.temp;

public class MergeKSortedLists {

//  Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode merged = new ListNode(-1), tail = merged;
		while (!isListEmpty(lists)) {
			int min = findMin(lists);
			if (min >= 0) {
				tail.next = lists[min];
				lists[min] = lists[min].next;
				tail = tail.next;
			}
		}
		return merged.next;
	}

	public static boolean isListEmpty(ListNode[] lists) {
		int length = lists.length - 1;
		while (length >= 0 && lists[length] == null)
			length--;
		return length < 0;
	}

	/**
	 * Find the minimum head out of the all lists and return its index.
	 * 
	 * @param lists
	 * @return
	 */
	private static int findMin(ListNode[] lists) {
		int length = lists.length;
		int min = -1;
		if (length > 0) {
			min = 0;
			for (int i = 1; i < length; i++) {
				if (lists[i] != null && (lists[min] == null || lists[min].val > lists[i].val))
					min = i;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		ListNode list1 = new MergeKSortedLists.ListNode(1);
		list1.next = new MergeKSortedLists.ListNode(2);
		list1.next.next = new MergeKSortedLists.ListNode(3);

		ListNode list2 = new MergeKSortedLists.ListNode(4);
		list2.next = new MergeKSortedLists.ListNode(5);
		list2.next.next = new MergeKSortedLists.ListNode(6);

		ListNode list3 = new MergeKSortedLists.ListNode(1);
		list3.next = new MergeKSortedLists.ListNode(2);
		list3.next.next = new MergeKSortedLists.ListNode(4);
		ListNode[] lists = { null, null, null };

		ListNode merged = new MergeKSortedLists().mergeKLists(lists);

		while (merged != null) {
			System.out.print(merged.val+",");
			merged = merged.next;
		}
	}

}
