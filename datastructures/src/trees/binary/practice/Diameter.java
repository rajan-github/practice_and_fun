package trees.binary.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 * @author rajan-c
 *
 */
public class Diameter {

	public static int diameterOfBinaryTree(TreeNode root) {
		int diameter = 0;
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.remove();
				if (node.left != null && node.right != null) {
					int leftHeight = height(node.left);
					int rightHeight = height(node.right);
					if (diameter < leftHeight + rightHeight + 2)
						diameter = leftHeight + rightHeight + 2;
					queue.add(node.left);
					queue.add(node.right);
				} else if (node.left != null) {
					int leftHeight = height(node.left);
					if (diameter < leftHeight + 1)
						diameter = leftHeight + 1;
					queue.add(node.left);
				} else if (node.right != null) {
					int rightHeight = height(node.right);
					if (diameter < rightHeight + 1)
						diameter = rightHeight + 1;
					queue.add(node.right);
				}
			}
		}
		return diameter;
	}

	private static int height(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(root));
	}

}
