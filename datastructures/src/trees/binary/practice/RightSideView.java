package trees.binary.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * @author rajan-c
 *
 */
public class RightSideView {
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);
			while (!queue.isEmpty()) {
				TreeNode node = queue.remove();
				if (!queue.isEmpty() && queue.peek() == null)
					rightView.add(node.val);
				if (node != null) {
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				} else {
					if (!queue.isEmpty())
						queue.add(null);

				}
			}
		}
		return rightView;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(rightSideView(root));
	}
}
