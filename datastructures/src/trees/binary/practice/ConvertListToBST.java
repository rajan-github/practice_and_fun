package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author rajan-c
 *
 */
public class ConvertListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		List<Integer> listItems = new ArrayList<>();
		while (head != null) {
			listItems.add(head.val);
			head = head.next;
		}
		return sortedArrayToBST(listItems, 0, listItems.size() - 1);
	}

	private static TreeNode sortedArrayToBST(List<Integer> listItems, int start, int end) {
		if (start >= 0 && start <= end) {
			int middle = (start + end) / 2;
			TreeNode root = new TreeNode(listItems.get(middle));
			root.left = sortedArrayToBST(listItems, start, middle - 1);
			root.right = sortedArrayToBST(listItems, middle + 1, end);
			return root;
		}
		return null;
	}
}
