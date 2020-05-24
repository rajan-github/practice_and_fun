package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * @author rajan-c
 *
 */
public class KthSmallestElement {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> inorderTraversal = new ArrayList<>();
		inorder(root, inorderTraversal);
		return inorderTraversal.get(k - 1);
	}

	private void inorder(TreeNode root, List<Integer> treeItems) {
		if (root == null)
			return;
		inorder(root.left, treeItems);
		treeItems.add(root.val);
		inorder(root.right, treeItems);
	}

	public static int kthSmallestIterative(TreeNode root, int k) {
		List<Integer> inorderTraversal = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root != null) {
			stack.push(root);
			root = root.left;
			while (!stack.isEmpty() && inorderTraversal.size() < k) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					inorderTraversal.add(root.val);
					root = root.right;
					if (root != null) {
						stack.push(root);
						root = root.left;
					}

				}
			}
		}
		return inorderTraversal.get(k - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(3);
		System.out.println(kthSmallestIterative(root, 6));
	}
}
