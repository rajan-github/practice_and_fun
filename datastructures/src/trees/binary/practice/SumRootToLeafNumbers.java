package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number. An example is the root-to-leaf path 1->2->3 which
 * represents the number 123. Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * @author rajan-c
 *
 */
public class SumRootToLeafNumbers {
	public static int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		List<Integer> paths = new ArrayList<>();
		dfs(root, new StringBuilder(), paths);
		return paths.get(0);
	}

	private static void dfs(TreeNode root, StringBuilder path, List<Integer> paths) {
		if (root != null && root.left == null && root.right == null) {
			path.append(root.val);
			if (paths.isEmpty())
				paths.add(Integer.parseInt(path.toString()));
			else {
				int temp = paths.remove(0);
				paths.add(Integer.parseInt(path.toString()) + temp);
			}
			path.delete(path.length() - 1, path.length());
			return;
		}
		path.append(root.val);
		if (root.left != null)
			dfs(root.left, path, paths);
		if (root.right != null)
			dfs(root.right, path, paths);
		path.delete(path.length() - 1, path.length());
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(2);
//		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
	}
}
