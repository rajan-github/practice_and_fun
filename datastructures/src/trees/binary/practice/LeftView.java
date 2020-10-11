package trees.binary.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
	public List<Integer> leftView(TreeNode root) {
		List<Integer> leftView = new ArrayList<>();
		if (root == null)
			return leftView;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		boolean leftMost = true;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node != null) {
				if (leftMost) {
					leftView.add(node.val);
					leftMost = false;
				}
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else {
				if (!queue.isEmpty()) {
					queue.add(null);
					leftMost = true;
				}
			}
		}
		return leftView;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		System.out.println(new LeftView().leftView(root));
	}
}
