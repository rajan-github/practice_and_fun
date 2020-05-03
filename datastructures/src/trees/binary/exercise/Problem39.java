package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree with three pointers (left, right and nextSibling), give
 * an algorithm for filling the nextSibling pointers assuming they are NULL
 * initially.
 * 
 * @author rajan-c
 *
 */
public class Problem39 {

	public static void setNextPointer(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		TreeNode previous = null;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node != null) {
				if (previous == null)
					previous = node;
				else {
					previous.next = node;
					previous = node;
				}
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else {
				if (!queue.isEmpty())
					queue.add(null);
				previous = null;
			}
		}
	}

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
	}
}
