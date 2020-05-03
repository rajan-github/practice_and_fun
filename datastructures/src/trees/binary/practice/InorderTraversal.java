package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import trees.binary.examples.BinaryTreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author rajan-c
 *
 */
public class InorderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<>();
		if (root == null)
			return traversal;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			if (root != null && root.left != null) {
				stack.push(root.left);
				root = root.left;
			} else {
				TreeNode node = stack.pop();
				traversal.add(node.val);
				if (node.right != null) {
					stack.push(node.right);
					root = node.right;
					continue;
				}
			}
		}
		return traversal;
	}

	public static void inorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		inorder(root.getLeft());
		System.out.println(root.getData());
		inorder(root.getRight());
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);

//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
		System.out.println(inorderTraversal(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
