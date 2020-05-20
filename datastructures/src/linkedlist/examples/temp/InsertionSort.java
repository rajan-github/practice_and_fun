package linkedlist.examples.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * Insertion sort on the linked list.
 * 
 * @author rajan-c
 *
 */
public class InsertionSort {
	public static ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		ListNode iterator = head;
		List<ListNode> nodeArray = new ArrayList<>();
		while (iterator != null) {
			nodeArray.add(iterator);
			iterator = iterator.next;
		}
		int sortedLength = 0, newLength = 1, size = nodeArray.size();
		for (newLength = 1; newLength < size; newLength++) {
			ListNode temp = nodeArray.get(newLength);
			nodeArray.remove(newLength);
			sortedLength = newLength - 1;
			while (sortedLength >= 0 && nodeArray.get(sortedLength).val > temp.val)
				sortedLength -= 1;
			nodeArray.add(sortedLength + 1, temp);
			if (sortedLength < size - 2)
				nodeArray.get(sortedLength + 1).next = nodeArray.get(sortedLength + 2);
			if (sortedLength >= 0)
				nodeArray.get(sortedLength).next = nodeArray.get(sortedLength + 1);
		}
		nodeArray.get(size - 1).next = null;
		return nodeArray.get(0);
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(4);

		node = insertionSortList(node);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
