package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * @author rajan-c
 *
 */
public class ValidateBST {
	public static boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrderTraversal(root, list);
		return isSorted(list);
	}

	private static boolean isSorted(List<Integer> list) {
		boolean sorted = true;
		int i = 0;
		for (i = 0; i < list.size() - 1 && sorted; i++) {
			if (list.get(i) >= list.get(i + 1))
				sorted = false;
		}
		return sorted;
	}

	private static void inOrderTraversal(TreeNode root, List<Integer> nodes) {
		if (root == null)
			return;
		inOrderTraversal(root.left, nodes);
		nodes.add(root.val);
		inOrderTraversal(root.right, nodes);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
//		root.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		System.out.println(isValidBST(root));
	}
}
